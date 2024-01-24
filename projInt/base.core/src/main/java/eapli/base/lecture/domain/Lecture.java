package eapli.base.lecture.domain;

import eapli.base.course.domain.Course;
import eapli.base.schedule.domain.Schedule;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Designation;

import javax.persistence.*;
import java.util.Calendar;

/**
 * The type Lecture.
 *
 * @author Inês Alves (29/04/2023)
 */
@Entity
public class Lecture extends Schedule implements AggregateRoot<Long>  {

    @Column(name = "TitleDefinition")
    @Embedded
    private Designation lectureTitle;

    @Column(name = "State")
    @Enumerated(EnumType.STRING)
    private LectureType lectureType;

    @OneToOne
    private Course course;

    /**
     * Instantiates a new Lecture.
     */
    protected Lecture() {
    }

    /**
     * Instantiates a new Lecture.
     *
     * @param lectureTitle the lecture title
     * @param lectureType  the lecture type
     */
    public Lecture(Designation lectureTitle, LectureType lectureType, Calendar initial,int duration, Course course) {
        super(initial,duration);
        this.lectureTitle = lectureTitle;
        this.lectureType = lectureType;
        this.course = course;
    }


    public Designation lectureTitle() {
        return lectureTitle;
    }


    public Course course() {
        return course;
    }

    public void addCourse(Course course) {
        this.course = course;
    }

    /**
     * Type lecture type.
     *
     * @return the lecture type
     */
    public LectureType type() {
        return lectureType;
    }

    /**
     * Is normal boolean.
     *
     * @return the boolean
     */
    public boolean isNormal() {
        return type() == LectureType.NORMAL;
    }

    /**
     * Is extra boolean.
     *
     * @return the boolean
     */
    public boolean isExtra() {
        return type() == LectureType.EXTRA;
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }



    @Override
    public String toString() {
        return "Class{" +
                ", ClassTitle=" + lectureTitle +
                ", classType=" + lectureType +
                '}';
    }
}
