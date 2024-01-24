package eapli.base.sharedBoard.application;

import eapli.base.postIt.services.PostItManagement;
import eapli.base.sharedBoard.service.SharedBoardService;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

/**
 * The type Archive board controller.
 */
public class ArchiveBoardController {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final PostItManagement postItManagement;

    /**
     * Instantiates a new Archive board controller.
     */
    public ArchiveBoardController() {
        this.postItManagement = PostItManagement.getInstance();
    }


    /**
     * Find admin permission boards list.
     *
     * @return the list
     */
    public List<String> findAdminPermissionBoards(){
        return postItManagement.findAdminPermissionBoards(findAutenticatedUser());
    }
    /**
     * Find autenticated user email address.
     *
     * @return the email address
     */
    public EmailAddress findAutenticatedUser() {
        return this.authorizationService.session().get().authenticatedUser().email();
    }


    /**
     * Archive shared board.
     *
     * @param sharedBoard the shared board
     */
    public void archiveSharedBoard(String sharedBoard){
        postItManagement.archiveSharedBoard(sharedBoard);
    }




}
