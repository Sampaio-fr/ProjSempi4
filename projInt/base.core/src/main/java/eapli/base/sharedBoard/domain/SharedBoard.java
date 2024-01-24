package eapli.base.sharedBoard.domain;


import eapli.base.cell.domain.Cell;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Shared board.
 *
 * @author Inês Alves (29/04/2023)
 * @author Alice Resende (09/05/2023)
 */
@Entity
@Table
public class SharedBoard implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , name = "sharedBoardTitle" )
    @Embedded
    @Unique
    private Designation sharedBoardTitle;

    @Column(name="sharedBoardState")
    @Enumerated(EnumType.STRING)
    private SharedBoardState boardState;

    @OneToOne
    private SystemUser ownerSharedBoard;

    /**
     * Instantiates a new Shared board.
     */
    public SharedBoard() {
    }

    /**
     * Instantiates a new Shared board.
     *
     * @param sharedBoardTitle the shared board title
     * @param ownerSharedBoard the owner shared board
     */
    public SharedBoard(Designation sharedBoardTitle, SystemUser ownerSharedBoard) {
        this.sharedBoardTitle = sharedBoardTitle;
        this.boardState = SharedBoardState.ENABLED;
        this.ownerSharedBoard = ownerSharedBoard;
    }

    public Designation sharedBoardTitle() {
        return sharedBoardTitle;
    }

    public SystemUser ownerSharedBoard() {
        return ownerSharedBoard;
    }
    public SharedBoardState sharedBoardState(){return boardState;}

    public void disable(){this.boardState=SharedBoardState.DISABLED;}
    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof SharedBoard)) {
            return false;
        }

        final SharedBoard that = (SharedBoard) other;
        if (this == that) {
            return true;
        }
        return  sharedBoardTitle.equals(that.sharedBoardTitle) && ownerSharedBoard.equals(that.ownerSharedBoard) ;
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SharedBoard:\n" +
                "SharedBoard Title = " + sharedBoardTitle +
                "\n Board State = " + boardState +
                "\n OwnerSharedBoard = " + ownerSharedBoard.username();
    }
}
