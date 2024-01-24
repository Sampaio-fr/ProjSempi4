package eapli.base.cell.domain;

import eapli.base.postIt.domain.PostIt;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Cell.
 */
@Entity
@Table
public class Cell implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CellRow row;

    @Embedded
    private CellColumn column;

    @OneToOne
    private PostIt postIt;

    @Enumerated(EnumType.STRING)
    private CellState cellState;

    @OneToOne
    private SharedBoard sharedBoard;


    public Cell(CellRow row, CellColumn column, SharedBoard sharedBoard) {
        this.row = row;
        this.column = column;
        this.sharedBoard = sharedBoard;
        this.cellState = CellState.EMPTY;
        this.postIt = null;
    }

    /**
     * Instantiates a new Cell.
     */
    public Cell() {
    }

    public CellState cellState() {
        return cellState;
    }

    public void replaceCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public CellRow row() {
        return row;
    }

    public void replaceRow(CellRow row) {
        this.row = row;
    }

    public CellColumn column() {
        return column;
    }

    public void replaceColumn(CellColumn column) {
        this.column = column;
    }

    public PostIt postIt() {
        return postIt;
    }

    public void replacePostIt(PostIt postIt) {
        this.postIt = postIt;
    }

    public SharedBoard sharedBoard() {
        return sharedBoard;
    }

    public void replaceSharedBoard(SharedBoard sharedBoard) {
        this.sharedBoard = sharedBoard;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Cell)) {
            return false;
        }

        final Cell that = (Cell) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity())
                && row.equals(that.row) && column.equals(that.column)
                && sharedBoard.equals(that.sharedBoard);
    }
    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(id, cell.id) && Objects.equals(row, cell.row) && Objects.equals(column, cell.column) && Objects.equals(sharedBoard, cell.sharedBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, column, sharedBoard);
    }


    @Override
    public String toString() {
        return " - Cell - " + "\n" +
                "Id:" + id +
                " | Cell State:" + cellState + "\n"  +
                "Post it: " + postIt + "\n" +
                "Row: " + row +
                " Column: "  + column + "\n"  ;
    }
}
