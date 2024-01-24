package eapli.base.sharedBoard.builder;

import eapli.base.cell.domain.Cell;
import eapli.base.user.domain.ECourseUser;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Set;

/**
 * The type Shared board builder.
 */
public  class SharedBoardBuilder implements DomainFactory<SharedBoard> {

    private SharedBoard sharedBoard;
    private Designation sharedBoardTitle;
    private SystemUser ownerSharedBoard;


    /**
     * Instantiates a new Shared board builder.
     */
    public SharedBoardBuilder() {
    }

    /**
     * With board title shared board builder.
     *
     * @param sharedBoardTitle the shared board title
     * @return the shared board builder
     */
    public SharedBoardBuilder withBoardTitle(final Designation sharedBoardTitle) {
        this.sharedBoardTitle = sharedBoardTitle;
        return this;
    }

    /**
     * With owner board shared board builder.
     *
     * @param ownerSharedBoard the owner shared board
     * @return the shared board builder
     */
    public SharedBoardBuilder withOwnerBoard(final SystemUser ownerSharedBoard) {
        this.ownerSharedBoard = ownerSharedBoard;
        return this;
    }

    private SharedBoard buildOrThrow() {
        if (sharedBoard != null) {
            return sharedBoard;
        }
        if (sharedBoardTitle != null && ownerSharedBoard !=null) {
            sharedBoard = new SharedBoard(sharedBoardTitle, ownerSharedBoard);
            return sharedBoard;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public SharedBoard build() {
        final SharedBoard board = buildOrThrow();
        sharedBoard =null;
        return board;
    }
}
