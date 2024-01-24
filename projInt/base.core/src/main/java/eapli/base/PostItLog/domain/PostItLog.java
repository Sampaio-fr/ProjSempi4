package eapli.base.PostItLog.domain;

import eapli.base.cell.domain.Cell;
import eapli.base.postIt.domain.Description;
import eapli.base.postIt.domain.PostIt;
import eapli.base.postIt.domain.Title;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

/**
 * The type Post it log.
 */
@Entity
@Table
public class PostItLog implements AggregateRoot<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Calendar date;

    @OneToOne
    private Cell cell;

    @OneToOne
    private PostIt postIt;

    @Embedded
    private Title title ;

    @Embedded
    private Description description;


    @Enumerated(EnumType.STRING)
    private PostItStateLog postItStateLog;

    /**
     * Instantiates a new Post it log.
     */
    public PostItLog() {
    }

    /**
     * Instantiates a new Post it log.
     *
     * @param date           the date
     * @param cell           the cell
     * @param postIt         the post it
     * @param postItStateLog the post it state log
     * @param title          the title
     * @param description    the description
     */
    public PostItLog(Calendar date, Cell cell, PostIt postIt, PostItStateLog postItStateLog,Title title,Description description) {
        this.date = date;
        this.cell = cell;
        this.postIt = postIt;
        this.postItStateLog = postItStateLog;
        this.title = title;
        this.description = description;
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
     * Title title.
     *
     * @return the title
     */
    public Title title() {
        return title;
    }

    /**
     * Replace title.
     *
     * @param title the title
     */
    public void replaceTitle(Title title) {
        this.title = title;
    }

    /**
     * Description description.
     *
     * @return the description
     */
    public Description description() {
        return description;
    }

    /**
     * Replace description.
     *
     * @param description the description
     */
    public void replaceDescription(Description description) {
        this.description = description;
    }

    /**
     * Cell cell.
     *
     * @return the cell
     */
    public Cell cell() {
        return cell;
    }

    /**
     * Replace cell.
     *
     * @param cell the cell
     */
    public void replaceCell(Cell cell) {
        this.cell = cell;
    }

    /**
     * Post it post it.
     *
     * @return the post it
     */
    public PostIt postIt() {
        return postIt;
    }

    /**
     * Replace post it.
     *
     * @param postIt the post it
     */
    public void replacePostIt(PostIt postIt) {
        this.postIt = postIt;
    }

    /**
     * Post it state log post it state log.
     *
     * @return the post it state log
     */
    public PostItStateLog postItStateLog() {
        return postItStateLog;
    }

    /**
     * Replace post it state log.
     *
     * @param postItStateLog the post it state log
     */
    public void replacePostItStateLog(PostItStateLog postItStateLog) {
        this.postItStateLog = postItStateLog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostItLog postItLog = (PostItLog) o;
        return Objects.equals(id, postItLog.id) && Objects.equals(date, postItLog.date) && Objects.equals(cell, postItLog.cell) && Objects.equals(postIt, postItLog.postIt) && postItStateLog == postItLog.postItStateLog;
    }

    @Override
    public boolean sameAs(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostItLog postItLog = (PostItLog) o;
        return Objects.equals(id, postItLog.id) && Objects.equals(date, postItLog.date) && Objects.equals(cell, postItLog.cell) && Objects.equals(postIt, postItLog.postIt) && postItStateLog == postItLog.postItStateLog;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, cell, postIt, postItStateLog);
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public String toString() {
        return "---POST-IT HISTORY---\n"+
                "Cell : " + cell.identity() + "\n"+
                "Post-it ID : " + postIt.postIt() + "\n"+
                "Post-it Title : " +postIt.title() + "\n"+
                "Post-it Description : "+postIt.description()+ "\n"+
                "Date : " + date.getTime() + "\n"+
                "State : " + postItStateLog+"\n";
    }
}
