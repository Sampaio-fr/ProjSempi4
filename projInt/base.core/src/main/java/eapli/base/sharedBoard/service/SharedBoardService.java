package eapli.base.sharedBoard.service;

import eapli.base.cell.domain.Cell;
import eapli.base.cell.domain.CellColumn;
import eapli.base.cell.domain.CellRow;
import eapli.base.cell.repositories.CellRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.permission.domain.AccessLevel;
import eapli.base.permission.domain.Permission;
import eapli.base.permission.repositories.PermissionRepository;
import eapli.base.sharedBoard.builder.SharedBoardBuilder;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.base.sharedBoard.domain.SharedBoardState;
import eapli.base.sharedBoard.repositories.SharedBoardRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedBoardService {
    private final SharedBoardRepository repoBoard;

    private final AuthorizationService authorizationService;


    private final CellRepository cellRepo;
    private final PermissionRepository permissionRepository;
    private final SystemUser systemUser;


    public SharedBoardService(SystemUser systemUser) {
        this.repoBoard = PersistenceContext.repositories().sharedBoardRepository();
        this.cellRepo = PersistenceContext.repositories().cellRepository();
        this.authorizationService = AuthzRegistry.authorizationService();
        this.permissionRepository = PersistenceContext.repositories().permissionRepository();
        this.systemUser = systemUser;
    }

    public Set<CellRow> createBoardRows(List<String> rowTitle){
        Set<CellRow> rows = new HashSet<>();
        int rowNumber=1;
        for(String title: rowTitle) {
            CellRow row = new CellRow(title, rowNumber);
            rows.add(row);
            rowNumber++;
        }
        return rows;
    }
    public Set<CellColumn> createBoardColumns(List<String> columnTitle){
        Set<CellColumn> columns = new HashSet<>();
        int columnNumber=1;
        for(String title: columnTitle) {
            CellColumn row = new CellColumn(title, columnNumber);
            columns.add(row);
            columnNumber++;
        }
        return columns;
    }
    public void createSharedBoard(String title, List<String> rowTitle,List<String> columnTitle){

        System.out.println(systemUser.email());
        Set<CellColumn> columns = createBoardColumns(columnTitle);
        Set<CellRow> rows = createBoardRows(rowTitle);
        SharedBoard sharedBoard = new SharedBoardBuilder()
                .withBoardTitle(Designation.valueOf(title))
                .withOwnerBoard(systemUser)
                .build();

        SharedBoard boardID = repoBoard.save(sharedBoard);
        for (CellColumn column : columns) {
            for (CellRow row : rows) {
                Cell cell = new Cell(row, column, boardID);
                cellRepo.save(cell);
            }
        }
        createPermissionOwner(systemUser,boardID);
        System.out.println(systemUser.email());
    }
    private void createPermissionOwner(SystemUser systemUser, SharedBoard sharedBoard) {
        Permission permission = new Permission(AccessLevel.ADMIN,sharedBoard,systemUser);
        permissionRepository.save(permission);
    }

    public List<String> findWriteAdminPermissionBoards(EmailAddress emailAddress){

        Iterable<Permission> list =new ArrayList<>();
        try {
            list = this.permissionRepository.findWriteAdmin(emailAddress);
        }catch(Exception e){
            System.out.println("No Permissions");
        }

        System.out.println(list);
        List<String> sharedBoardList = new ArrayList<String>();
        for (Permission permission :list) {
            if(permission.SharedBoard().sharedBoardState().equals(SharedBoardState.ENABLED)){
                sharedBoardList.add(permission.SharedBoard().sharedBoardTitle().toString());
            }
        }
        return sharedBoardList;
    }




    /**
     * Find autenticated user email address.
     *
     * @return the email address
     */
    public EmailAddress findAutenticatedUser(){
        return systemUser.email();
    }


}
