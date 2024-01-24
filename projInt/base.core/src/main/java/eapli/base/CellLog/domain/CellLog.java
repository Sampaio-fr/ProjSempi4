package eapli.base.CellLog.domain;

import eapli.base.PostItLog.domain.PostItLog;
import eapli.base.cell.domain.Cell;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * The type Cell log.
 */
@Entity
@Table
public class CellLog implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Calendar date;

    @OneToOne
    private Cell cell;

    @OneToMany
    @Column(name = "PostItLog")
    private List<PostItLog> postItLogList;


    /**
     * Instantiates a new Cell log.
     */
    public CellLog() {
    }

    /**
     * Instantiates a new Cell log.
     *
     * @param date          the date
     */
    public CellLog(Calendar date, Cell cell) {
        this.date = date;
        this.cell = cell;
        this.postItLogList = new ArrayList<>();
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


    public Cell cell() {
        return cell;
    }


    public void replaceCell(Cell cell) {
        this.cell = cell;
    }


    /**
     * Post it log list list.
     *
     * @return the list
     */
    public List<PostItLog> postItLogList() {
        return postItLogList;
    }

    /**
     * Replace post it log list.
     *
     * @param postItLogList the post it log list
     */
    public void replacePostItLogList(List<PostItLog> postItLogList) {
        this.postItLogList = postItLogList;
    }

    /**
     * Add post it log list.
     *
     * @param postIt the post it
     */
    public void addPostItLogList(PostItLog postIt) {
        this.postItLogList.add(postIt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellLog cellLog = (CellLog) o;
        return Objects.equals(id, cellLog.id) && Objects.equals(date, cellLog.date) &&  Objects.equals(postItLogList, cellLog.postItLogList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date,postItLogList);
    }

    @Override
    public boolean sameAs(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellLog cellLog = (CellLog) o;
        return Objects.equals(id, cellLog.id) && Objects.equals(date, cellLog.date) && Objects.equals(postItLogList, cellLog.postItLogList);
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public String toString() {
        return "---CELL HISTORY---\n" +
                "Date : " + date.getTime() + "\n"+
                "Cell : " + cell.identity() + "\n"+
                "---POST-IT HISTORY---\n " + postItLogList + "\n";
    }
}
