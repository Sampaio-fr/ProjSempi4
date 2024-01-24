package eapli.base.postIt.applications;

import eapli.base.cell.domain.Cell;
import eapli.base.postIt.services.PostItManagement;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

/**
 * The type Update post it controller.
 */
public class UndoPostItController {

    private final PostItManagement postItManagement;
    private final SystemUser systemUser;

    /**
     * Instantiates a new Update post it controller.
     */
    public UndoPostItController(SystemUser systemUser) {
        this.postItManagement = PostItManagement.getInstance();
        this.systemUser = systemUser;
    }


    /**
     * Find occupied cells list.
     *
     * @param sharedBoard the shared board
     * @return the list
     */
    public List<Cell> findUpdatedOccupiedCells(SharedBoard sharedBoard) {
        return this.postItManagement.findUpdatedOccupiedCells(sharedBoard);
    }

    /**
     * Find owned shared boards iterable.
     *
     * @param emailAddress the email address
     * @return the iterable
     */
    public Iterable<SharedBoard> findOwnedSharedBoards(EmailAddress emailAddress) {
        return this.postItManagement.findOwnedSharedBoards(emailAddress);
    }

    /**
     * Find write admin permission boards list.
     *
     * @return the list
     */
    public List<String> findWriteAdminPermissionBoards() {
        return this.postItManagement.findWriteAdminPermissionBoards(autenticatedUser());
    }

    /**
     * Find autenticated user email address.
     *
     * @return the email address
     */
    public EmailAddress autenticatedUser() {
        return systemUser.email();
    }


    /**
     * Update post it.
     *
     * @param cell the cell
     */
    public void undoPostIt(Cell cell) {
        this.postItManagement.undoPostIt(cell);
    }


    /**
     * Find shared board string shared board.
     *
     * @param id the id
     * @return the shared board
     */
    public SharedBoard findSharedBoardString(String id) {
        return this.postItManagement.findSharedBoardString(id);
    }

    /**
     * Find cell.
     *
     * @param id the id
     * @return the cell
     */
    public Cell findCell(long id) {
        return this.postItManagement.findCell(id);
    }

}
