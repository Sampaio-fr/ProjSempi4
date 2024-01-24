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
public class UpdatePostItController {

    private final PostItManagement postItManagement;
    private final SystemUser systemUser;

    /**
     * Instantiates a new Update post it controller.
     */
    public UpdatePostItController(SystemUser systemUser) {
        this.postItManagement = PostItManagement.getInstance();
        this.systemUser = systemUser;
    }


    /**
     * Find ocuppied cells list.
     *
     * @param sharedBoard the shared board
     * @return the list
     */
    public List<Cell> findOcuppiedCells(SharedBoard sharedBoard) {
        return this.postItManagement.findOccupiedCells(sharedBoard);
    }

    /**
     * Find empty cells list.
     *
     * @param sharedBoard the shared board
     * @return the list
     */
    public List<Cell> findEmptyCells(SharedBoard sharedBoard){
        return this.postItManagement.findEmptyCells(sharedBoard);
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
     * @param cell        the cell
     * @param title       the title
     * @param description the description
     */
    public void updatePostIt(Cell cell, String title, String description) {
        this.postItManagement.updatePostIt(cell, title, description);
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
     * Find cell cell.
     *
     * @param id the id
     * @return the cell
     */
    public Cell findCell(long id) {
        return this.postItManagement.findCell(id);
    }

    public void movePostit(Cell oldCell, Cell newCell) {
        this.postItManagement.movePostIt(oldCell, newCell);
    }
}
