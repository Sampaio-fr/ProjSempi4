package eapli.base.SharedBoardLog.domain;

import eapli.base.CellLog.domain.CellLog;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * The type Shared board log.
 */
@Entity
@Table
public class SharedBoardLog implements AggregateRoot<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Calendar date;

    @OneToOne
    private SharedBoard sharedBoard;

    @Enumerated(EnumType.STRING)
    private SharedBoardStateLog sharedBoardStateLog;

    @OneToMany
    private List<CellLog> cellLogList;

    /**
     * Instantiates a new Shared board log.
     *
     * @param date        the date
     * @param sharedBoard the shared board
     */
    public SharedBoardLog(Calendar date, SharedBoard sharedBoard) {
        this.date = date;
        this.sharedBoard = sharedBoard;
        this.cellLogList = new ArrayList<>();
        this.sharedBoardStateLog = SharedBoardStateLog.Created;
    }

    /**
     * Instantiates a new Shared board log.
     */
    protected SharedBoardLog() {
    }

    /**
     * Id long.
     *
     * @return the long
     */
    public Long id() {
        return id;
    }

    /**
     * Replace id.
     *
     * @param id the id
     */
    public void replaceId(Long id) {
        this.id = id;
    }

    /**
     * Date calendar.
     *
     * @return the calendar
     */
    public Calendar date() {
        return date;
    }

    /**
     * Replace date.
     *
     * @param date the date
     */
    public void replaceDate(Calendar date) {
        this.date = date;
    }

    /**
     * Shared board shared board.
     *
     * @return the shared board
     */
    public SharedBoard sharedBoard() {
        return sharedBoard;
    }

    /**
     * Replace shared board.
     *
     * @param sharedBoard the shared board
     */
    public void replaceSharedBoard(SharedBoard sharedBoard) {
        this.sharedBoard = sharedBoard;
    }

    /**
     * Cell log list list.
     *
     * @return the list
     */
    public List<CellLog> cellLogList() {
        return cellLogList;
    }

    /**
     * Replace cell log list.
     *
     * @param cellLogList the cell log list
     */
    public void replaceCellLogList(List<CellLog> cellLogList) {
        this.cellLogList = cellLogList;
    }

    /**
     * Add cell log list.
     *
     * @param cellLog the cell log
     */
    public void addCellLogList(CellLog cellLog) {
        this.cellLogList.add(cellLog);
    }

    /**
     * Shared board state log shared board state log.
     *
     * @return the shared board state log
     */
    public SharedBoardStateLog sharedBoardStateLog() {
        return sharedBoardStateLog;
    }

    /**
     * Replace shared board state log.
     *
     * @param sharedBoardStateLog the shared board state log
     */
    public void replaceSharedBoardStateLog(SharedBoardStateLog sharedBoardStateLog) {
        this.sharedBoardStateLog = sharedBoardStateLog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedBoardLog that = (SharedBoardLog) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(sharedBoard, that.sharedBoard) && Objects.equals(cellLogList, that.cellLogList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, sharedBoard, cellLogList);
    }

    @Override
    public boolean sameAs(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SharedBoardLog that = (SharedBoardLog) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(sharedBoard, that.sharedBoard) && Objects.equals(cellLogList, that.cellLogList);
    }

    @Override
    public String toString() {
        return "---SHARED BOARD HISTORY---\n" +
                "Date : " + date.getTime()+ "\n"+
                "State : " + sharedBoardStateLog + "\n";
    }

    @Override
    public Long identity() {
        return id();
    }
}
