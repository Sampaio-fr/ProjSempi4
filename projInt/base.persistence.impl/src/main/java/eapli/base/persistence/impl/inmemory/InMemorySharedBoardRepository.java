package eapli.base.persistence.impl.inmemory;

import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.base.sharedBoard.repositories.SharedBoardRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemorySharedBoardRepository extends InMemoryDomainRepository<SharedBoard,Long> implements SharedBoardRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<SharedBoard> listOwnedBoards(EmailAddress email) {
        return null;
    }

    @Override
    public SharedBoard getBoardWithTitle(Designation title) {
        return null;
    }

    public SharedBoard findSharedBoardByTitle(Designation title) {

        return null;
    }

    @Override
    public SharedBoard findSharedBoardString(Long id) {
        return null;
    }
}
