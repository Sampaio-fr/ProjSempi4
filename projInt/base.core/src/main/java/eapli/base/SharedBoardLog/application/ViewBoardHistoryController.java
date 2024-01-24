package eapli.base.SharedBoardLog.application;

import eapli.base.CellLog.domain.CellLog;
import eapli.base.SharedBoardLog.domain.SharedBoardLog;
import eapli.base.SharedBoardLog.service.ViewBoardHistoryService;
import eapli.base.sharedBoard.service.SharedBoardService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public class ViewBoardHistoryController {

    private final ViewBoardHistoryService service ;
    private final SharedBoardService boardService ;
    public ViewBoardHistoryController(SystemUser systemUser) {
        this.service = new ViewBoardHistoryService();
        this.boardService = new SharedBoardService(systemUser);
    }



    public SharedBoardLog viewSharedBoardHistory(String boardTitle) {
        return service.viewBoardHistory(boardTitle);
    }

    public List<CellLog> viewBoardCellsHistory(SharedBoardLog boardLog) {
        return service.viewCellsHistory(boardLog);
    }

    public String viewBoardPostItHistory(List<CellLog> cellLogs){
        return service.viewPostItHistory(cellLogs);
    }

    public List<String> findWriteAdminPermissionBoards() {
        return boardService.findWriteAdminPermissionBoards(boardService.findAutenticatedUser());
    }


}
