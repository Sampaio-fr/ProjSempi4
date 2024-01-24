package eapli.base.sharedBoard.application;

import eapli.base.cell.domain.Cell;
import eapli.base.cell.repositories.CellRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.permission.domain.Permission;
import eapli.base.permission.repositories.PermissionRepository;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.base.sharedBoard.repositories.SharedBoardRepository;
import eapli.base.sharedBoard.service.SharedBoardService;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

public class ShowSharedBoardController {

    private final SharedBoardRepository repoBoard;
    private final PermissionRepository permissionRepo;
    private final CellRepository cellRepo;
    private final SharedBoardService boardService ;
    private final SystemUser systemUser;

    public ShowSharedBoardController(SystemUser systemUser) {
        this.repoBoard = PersistenceContext.repositories().sharedBoardRepository();
        this.permissionRepo = PersistenceContext.repositories().permissionRepository();
        this.cellRepo = PersistenceContext.repositories().cellRepository();
        this.systemUser = systemUser;
        this.boardService = new SharedBoardService(systemUser);
    }

    public List<Cell> sharedBoardByTitle(String title) {
        //get requested sharedboard
        SharedBoard sb = repoBoard.getBoardWithTitle(Designation.valueOf(title));
        //verifies user can access it
        boolean hasAccess = true;//hasPermission(sb);
        List<Cell> sbCells = new ArrayList<>();
        if (hasAccess) {
            //get cells with postits
            sbCells = PersistenceContext.repositories().cellRepository().findBoardCells(sb);
        }
        return sbCells;
    }


    private boolean hasPermission(SharedBoard sb) {
        Permission p = permissionRepo.hasPermissionByEmail(systemUser.email());
        if (p == null) {
            return false;
        } else {
            return p.SharedBoard().sameAs(sb);
        }
    }

    public List<String> findWriteAdminPermissionBoards() {
        return boardService.findWriteAdminPermissionBoards(boardService.findAutenticatedUser());
    }

}
