package eapli.base.sharedBoard.application;

import eapli.base.sharedBoard.service.BoardPermissionsService;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public class ShareBoardController {

    private final BoardPermissionsService boardService;
    private final SystemUser systemUser;

    public ShareBoardController(SystemUser systemUser) {
        this.boardService = new BoardPermissionsService();
        this.systemUser = systemUser;
    }

    /**
     * Open courses iterable.
     *
     * @return the iterable
     */
    public List<String> listOwnedBoards() {
        return boardService.listOwnedBoards(systemUser.email());
    }


    public boolean readPermission(String board, String email) {
        EmailAddress mail = EmailAddress.valueOf(email);
        return boardService.readPermission(board, mail);
    }

    public boolean writePermission(String board, String email) {
        EmailAddress mail = EmailAddress.valueOf(email);
        return boardService.writePermission(board, mail);
    }

}
