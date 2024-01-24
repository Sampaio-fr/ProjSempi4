package eapli.base.postIt.services;

import eapli.base.CellLog.domain.CellLog;
import eapli.base.CellLog.repositories.CellLogRepository;
import eapli.base.PostItLog.domain.PostItLog;
import eapli.base.PostItLog.domain.PostItStateLog;
import eapli.base.PostItLog.repositories.PostItLogRepository;
import eapli.base.SharedBoardLog.domain.SharedBoardLog;
import eapli.base.SharedBoardLog.repositories.SharedBoardLogRepository;
import eapli.base.cell.domain.Cell;
import eapli.base.cell.domain.CellState;
import eapli.base.cell.repositories.CellRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.permission.domain.AccessLevel;
import eapli.base.permission.domain.Permission;
import eapli.base.permission.repositories.PermissionRepository;
import eapli.base.postIt.domain.Description;
import eapli.base.postIt.domain.PostIt;
import eapli.base.postIt.domain.Title;
import eapli.base.postIt.repositories.PostItRepository;
import eapli.base.sharedBoard.application.SharedBoardSynchronizerImpl;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.base.sharedBoard.domain.SharedBoardState;
import eapli.base.sharedBoard.repositories.SharedBoardRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The type Post it management.
 */
public class PostItManagement {

    private static PostItManagement instance;
    private final SharedBoardRepository sharedBoardRepository;
    private final CellRepository cellRepository;
    private final PostItRepository postItRepository;
    private final PermissionRepository permissionRepository;
    private final SharedBoardLogRepository sharedBoardLogRepository;
    private final CellLogRepository cellLogRepository;
    private final PostItLogRepository postItLogRepository;
    private final SharedBoardSynchronizerImpl synchronizer = SharedBoardSynchronizerImpl.getInstance();


    /**
     * Instantiates a new Post it management.
     */
    private PostItManagement() {
        this.sharedBoardRepository = PersistenceContext.repositories().sharedBoardRepository();
        this.cellRepository = PersistenceContext.repositories().cellRepository();
        this.postItRepository = PersistenceContext.repositories().postItRepository();
        this.sharedBoardLogRepository = PersistenceContext.repositories().sharedBoardLogRepository();
        this.cellLogRepository = PersistenceContext.repositories().cellLogRepository();
        this.postItLogRepository = PersistenceContext.repositories().postItLogRepository();
        this.permissionRepository = PersistenceContext.repositories().permissionRepository();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static PostItManagement getInstance() {
        if (instance == null) {
            return instance = new PostItManagement();
        }
        return instance;
    }

    /**
     * Find empty cells list.
     *
     * @param sharedBoard the shared board
     * @return the list
     */
    public List<Cell> findEmptyCells(SharedBoard sharedBoard) {
        return this.cellRepository.findBoardEmptyCells(sharedBoard);
    }

    /**
     * Find occupied cells list.
     *
     * @param sharedBoard the shared board
     * @return the list
     */
    public List<Cell> findOccupiedCells(SharedBoard sharedBoard) {
        return this.cellRepository.findOccupiedCells(sharedBoard);
    }

    /**
     * Find occupied cells list.
     *
     * @param sharedBoard the shared board
     * @return the list
     */
    public List<Cell> findUpdatedOccupiedCells(SharedBoard sharedBoard) {
        return this.cellRepository.findUpdatedOccupiedCells(sharedBoard);
    }

    /**
     * Find owned shared boards iterable.
     *
     * @param emailAddress the email address
     * @return the iterable
     */
    public Iterable<SharedBoard> findOwnedSharedBoards(EmailAddress emailAddress) {
        return this.sharedBoardRepository.listOwnedBoards(emailAddress);
    }

    /**
     * Find write admin permission boards list.
     *
     * @param emailAddress the email address
     * @return the list
     */
    public List<String> findWriteAdminPermissionBoards(EmailAddress emailAddress) {

        Iterable<Permission> list = new ArrayList<>();
        try {
            list = this.permissionRepository.findWriteAdmin(emailAddress);
        } catch (Exception e) {
            System.out.println("No Permissions");
        }

        List<String> sharedBoardList = new ArrayList<>();
        for (Permission permission : list) {
            if (permission.SharedBoard().sharedBoardState().equals(SharedBoardState.ENABLED)) {
                System.out.println(permission.SharedBoard() + " -> " + permission.AccessLevel());
                sharedBoardList.add(permission.SharedBoard().sharedBoardTitle().toString());
            }
        }
        return sharedBoardList;
    }


    public Cell findCell(long id) {

        return this.cellRepository.findById(id);
    }

    /**
     * Create post it.
     *
     * @param cell        the cell
     * @param title       the title
     * @param description the description
     */
    public void createPostIt(Cell cell, String title, String description) {

        synchronized (synchronizer.createCellLock(cell.identity())) {
            if (cell.sharedBoard().sharedBoardState().equals(SharedBoardState.ENABLED)) {
                if (cell.cellState().equals(CellState.EMPTY)) {
                    PostIt postIt = new PostIt(new Title(title), new Description(description));
                    postIt = this.postItRepository.save(postIt);

                    cell.replacePostIt(postIt);
                    cell.replaceCellState(CellState.OCCUPIED);

                    cell = this.cellRepository.save(cell);

                    synchronizer.getLock().lock();
                    try {
                        PostItLog postItLog = new PostItLog(Calendar.getInstance(), cell, postIt, PostItStateLog.Create, new Title(title), new Description(description));
                        postItLog = this.postItLogRepository.save(postItLog);

                        CellLog cellLog;
                        SharedBoardLog sharedBoardLog;
                        try {
                            sharedBoardLog = this.sharedBoardLogRepository.findSharedBoardLogContainsSharedBoard(cell.sharedBoard());
                        } catch (Exception e) {
                            sharedBoardLog = new SharedBoardLog(Calendar.getInstance(), cell.sharedBoard());
                            sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
                        }

                        try {
                            cellLog = this.cellLogRepository.findCellLogContainsCell(cell);
                        } catch (Exception e) {
                            cellLog = new CellLog(Calendar.getInstance(), cell);
                            cellLog = this.cellLogRepository.save(cellLog);
                            sharedBoardLog.addCellLogList(cellLog);
                            sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
                        }

                        cellLog.addPostItLogList(postItLog);
                        cellLog = this.cellLogRepository.save(cellLog);
                    } finally {
                        synchronizer.getLock().unlock();
                    }
                } else {
                    throw new RuntimeException("Another user already created a post it in this cell!");
                }
            } else {
                throw new RuntimeException("The SharedBoard was closed!");
            }
        }
    }

    /**
     * Update post it.
     *
     * @param cell        the cell
     * @param title       the title
     * @param description the description
     */
    public void updatePostIt(Cell cell, String title, String description) {

        PostIt postIt = cell.postIt();
        synchronized (synchronizer.createPostItLock(postIt.identity())) {
            if (cell.sharedBoard().sharedBoardState().equals(SharedBoardState.ENABLED)) {
                postIt.replaceTitle(new Title(title));
                postIt.replaceDescription(new Description(description));
                postIt = this.postItRepository.save(postIt);
            } else {
                throw new RuntimeException("The SharedBoard was closed!");
            }
        }

        synchronized (synchronizer.createCellLock(cell.identity())) {
            if (cell.sharedBoard().sharedBoardState().equals(SharedBoardState.ENABLED)) {
                cell.replacePostIt(postIt);
                cell = this.cellRepository.save(cell);
            } else {
                throw new RuntimeException("The SharedBoard was closed!");
            }
        }

        synchronizer.getLock().lock();
        try {
            PostItLog postItLog = new PostItLog(Calendar.getInstance(), cell, postIt, PostItStateLog.Update, new Title(title), new Description(description));
            postItLog = this.postItLogRepository.save(postItLog);

            CellLog cellLog;
            SharedBoardLog sharedBoardLog;
            try {
                sharedBoardLog = this.sharedBoardLogRepository.findSharedBoardLogContainsSharedBoard(cell.sharedBoard());
            } catch (Exception e) {
                sharedBoardLog = new SharedBoardLog(Calendar.getInstance(), cell.sharedBoard());
                sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
            }

            try {
                cellLog = this.cellLogRepository.findCellLogContainsCell(cell);
            } catch (Exception e) {
                cellLog = new CellLog(Calendar.getInstance(), cell);
                cellLog = this.cellLogRepository.save(cellLog);
                sharedBoardLog.addCellLogList(cellLog);
                sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
            }

            cellLog.addPostItLogList(postItLog);
            cellLog = this.cellLogRepository.save(cellLog);
            sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
        } finally {
            synchronizer.getLock().unlock();
        }
    }

    /**
     * Undo post it.
     *
     * @param cell the cell
     */
    public void undoPostIt(Cell cell) {

        PostIt postIt = cell.postIt();
        PostItLog lastPostItLog;
        synchronized (synchronizer.createPostItLock(postIt.identity())) {
            if (cell.sharedBoard().sharedBoardState().equals(SharedBoardState.ENABLED)) {
                lastPostItLog = this.postItLogRepository.findLastPostItLog(postIt);
                if (lastPostItLog.postItStateLog().equals(PostItStateLog.Update)) {
                    lastPostItLog = this.postItLogRepository.findLastPostItLogUpdate(postIt);
                    postIt.replaceTitle(lastPostItLog.title());
                    postIt.replaceDescription(lastPostItLog.description());
                    postIt = this.postItRepository.save(postIt);
                }
            } else {
                throw new RuntimeException("The SharedBoard was closed!");
            }

            synchronized (synchronizer.createCellLock(cell.identity())) {
                if (cell.sharedBoard().sharedBoardState().equals(SharedBoardState.ENABLED)) {
                    cell.replacePostIt(postIt);
                    cell = this.cellRepository.save(cell);
                } else {
                    throw new RuntimeException("The SharedBoard was closed!");
                }
            }

            synchronizer.getLock().lock();
            try {
                PostItLog postItLog = new PostItLog(Calendar.getInstance(), cell, postIt, PostItStateLog.Undo, lastPostItLog.title(), lastPostItLog.description());
                postItLog = this.postItLogRepository.save(postItLog);

                CellLog cellLog;
                SharedBoardLog sharedBoardLog;
                try {
                    sharedBoardLog = this.sharedBoardLogRepository.findSharedBoardLogContainsSharedBoard(cell.sharedBoard());
                } catch (Exception e) {
                    sharedBoardLog = new SharedBoardLog(Calendar.getInstance(), cell.sharedBoard());
                    sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
                }

                try {
                    cellLog = this.cellLogRepository.findCellLogContainsCell(cell);
                } catch (Exception e) {
                    cellLog = new CellLog(Calendar.getInstance(), cell);
                    cellLog = this.cellLogRepository.save(cellLog);
                    sharedBoardLog.addCellLogList(cellLog);
                    sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
                }

                cellLog.addPostItLogList(postItLog);
                cellLog = this.cellLogRepository.save(cellLog);
                sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);

            } finally {
                synchronizer.getLock().unlock();
            }
        }
    }


    /**
     * Find shared board string shared board.
     *
     * @param title the title
     * @return the shared board
     */
    public SharedBoard findSharedBoardString(String title) {
        return this.sharedBoardRepository.findSharedBoardByTitle(Designation.valueOf(title));
    }


    /**
     * Move postit.
     *
     * @param oldCell the old cell
     * @param newCell the new cell
     */
    public void movePostIt(Cell oldCell, Cell newCell) {

        PostIt postIt = oldCell.postIt();

        synchronized (synchronizer.createPostItLock(postIt.identity())) {
            synchronized (synchronizer.createCellLock(newCell.identity())) {
                if (oldCell.sharedBoard().sharedBoardState().equals(SharedBoardState.ENABLED)) {
                    try {
                        oldCell.replacePostIt(null);
                        oldCell.replaceCellState(CellState.EMPTY);
                        oldCell = this.cellRepository.save(oldCell);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        newCell.replacePostIt(postIt);
                        newCell.replaceCellState(CellState.OCCUPIED);
                        newCell = this.cellRepository.save(newCell);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    throw new RuntimeException("The SharedBoard was closed!");
                }
            }
        }

        synchronizer.getLock().lock();
        PostItLog postItLogNew = null, postItLogOld = null;
        try {
            try {
                postItLogOld = new PostItLog(Calendar.getInstance(), oldCell, postIt, PostItStateLog.Delete, new Title("Deleted"), new Description("Deleted"));
                postItLogOld = this.postItLogRepository.save(postItLogOld);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                postItLogNew = new PostItLog(Calendar.getInstance(), newCell, postIt, PostItStateLog.Create, postIt.title(), postIt.description());
                postItLogNew = this.postItLogRepository.save(postItLogNew);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            CellLog cellLogOld, cellLogNew;
            SharedBoardLog sharedBoardLog;
            try {
                sharedBoardLog = this.sharedBoardLogRepository.findSharedBoardLogContainsSharedBoard(oldCell.sharedBoard());
            } catch (Exception e) {
                sharedBoardLog = new SharedBoardLog(Calendar.getInstance(), oldCell.sharedBoard());
                sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
            }

            try {
                cellLogOld = this.cellLogRepository.findCellLogContainsCell(oldCell);
            } catch (Exception e) {
                cellLogOld = new CellLog(Calendar.getInstance(), oldCell);
                cellLogOld = this.cellLogRepository.save(cellLogOld);
                sharedBoardLog.addCellLogList(cellLogOld);
                sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
            }

            try {
                cellLogNew = this.cellLogRepository.findCellLogContainsCell(newCell);
            } catch (Exception e) {
                cellLogNew = new CellLog(Calendar.getInstance(), newCell);
                cellLogNew = this.cellLogRepository.save(cellLogNew);
                sharedBoardLog.addCellLogList(cellLogNew);
                sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
            }

            if (postItLogOld != null && postItLogNew != null) {
                cellLogOld.addPostItLogList(postItLogOld);
                cellLogOld = this.cellLogRepository.save(cellLogOld);
                sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);

                cellLogNew.addPostItLogList(postItLogNew);
                cellLogNew = this.cellLogRepository.save(cellLogNew);
                sharedBoardLog = this.sharedBoardLogRepository.save(sharedBoardLog);
            }
        } finally {
            synchronizer.getLock().unlock();
        }
    }

    /**
     * Find admin permission boards list.
     *
     * @param emailAddress the email address
     * @return the list
     */
    public List<String> findAdminPermissionBoards(EmailAddress emailAddress) {

        Iterable<Permission> list = new ArrayList<>();
        try {
            list = this.permissionRepository.findWriteAdmin(emailAddress);
        } catch (Exception e) {
            System.out.println("No Permissions");
        }

        List<String> sharedBoardList = new ArrayList<String>();
        for (Permission permission : list) {
            if (permission.SharedBoard().sharedBoardState().equals(SharedBoardState.ENABLED)
                    && permission.SharedBoard().ownerSharedBoard().email().equals(emailAddress)
                    && permission.AccessLevel().equals(AccessLevel.ADMIN)) {

                sharedBoardList.add(permission.SharedBoard().sharedBoardTitle().toString());

            }
        }
        return sharedBoardList;
    }

    /**
     * Archive shared board.
     *
     * @param title the title
     */
    public void archiveSharedBoard(String title) {
        SharedBoard sharedBoard = this.sharedBoardRepository.findSharedBoardByTitle(Designation.valueOf(title));

        sharedBoard.disable();
        sharedBoard = this.sharedBoardRepository.save(sharedBoard);

    }

}
