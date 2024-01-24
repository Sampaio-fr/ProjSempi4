package eapli.base.postIt.repositories;

import eapli.base.CellLog.domain.CellLog;
import eapli.base.PostItLog.domain.PostItLog;
import eapli.base.SharedBoardLog.domain.SharedBoardLog;
import eapli.base.postIt.domain.PostIt;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

/**
 * The interface Permission repository.
 */
public interface PostItRepository extends DomainRepository<Long, PostIt> {

}
