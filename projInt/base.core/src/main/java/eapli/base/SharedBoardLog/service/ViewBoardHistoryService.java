package eapli.base.SharedBoardLog.service;

import eapli.base.CellLog.domain.CellLog;
import eapli.base.CellLog.repositories.CellLogRepository;
import eapli.base.PostItLog.domain.PostItLog;
import eapli.base.PostItLog.repositories.PostItLogRepository;
import eapli.base.SharedBoardLog.domain.SharedBoardLog;
import eapli.base.SharedBoardLog.repositories.SharedBoardLogRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.sharedBoard.repositories.SharedBoardRepository;
import eapli.framework.general.domain.model.Designation;

import java.util.ArrayList;
import java.util.List;

public class ViewBoardHistoryService {
    private final SharedBoardLogRepository boardLogRepo;

    private final CellLogRepository cellLogRepo;

    private final PostItLogRepository postItLogRepo;

    private final SharedBoardRepository boardRepo;

    public ViewBoardHistoryService() {
        this.boardLogRepo = PersistenceContext.repositories().sharedBoardLogRepository();
        this.cellLogRepo = PersistenceContext.repositories().cellLogRepository();
        this.postItLogRepo = PersistenceContext.repositories().postItLogRepository();
        this.boardRepo = PersistenceContext.repositories().sharedBoardRepository();
    }

    public SharedBoardLog viewBoardHistory(String boardTitle){
        new ViewBoardHistoryService();
        return boardLogRepo.findSharedBoardHistory(boardRepo.findSharedBoardByTitle(Designation.valueOf(boardTitle)));
    }
    public List<CellLog> viewCellsHistory(SharedBoardLog boardLog){
        new ViewBoardHistoryService();
        return boardLogRepo.findCellsHistory(boardLog);
    }
    public String viewPostItHistory(List<CellLog> cellLogs){
        new ViewBoardHistoryService();
        List<String> postItLogListStr = new ArrayList<>();
        for (CellLog c : cellLogs) {
            for (PostItLog postItLog : c.postItLogList()) {
                postItLogListStr.add(postItLog.cell().identity().toString());
                postItLogListStr.add(postItLog.postIt().identity().toString());
                postItLogListStr.add(postItLog.postItStateLog().toString());
                postItLogListStr.add(postItLog.date().getTime().toString());
            }
        }
       return String.join(",", postItLogListStr);
    }
}
