package eapli.base.enrollment.domain;

import eapli.base.course.domain.Course;
import eapli.base.student.domain.Student;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

/**
 * The type Enrollment.
 *
 * @author aliceresende (29-04-2022)
 */
@Entity
@Table
public class Enrollment implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnroll;

    @Enumerated(EnumType.STRING)
    private EnrollmentState enrollState;

    @OneToOne
    private Student student;

    @OneToOne
    private Course course;


    /**
     * Instantiates a new Enrollment.
     */
    public Enrollment() {
    }


    /**
     * Instantiates a new Enrollment.
     *
     * @param student the student
     * @param course  the course
     */
    public Enrollment(final Student student, final Course course) {
        Preconditions.noneNull(student, course);
        this.enrollState = EnrollmentState.WAITING;
        this.student = student;
        this.course = course;
    }


    /**
     * Gets enroll state.
     *
     * @return the enroll state
     */
    public EnrollmentState enrollState() {
        return enrollState;
    }


    /**
     * Gets student.
     *
     * @return the student
     */
    public Student student() {
        return student;
    }


    /**
     * Gets course.
     *
     * @return the course
     */
    public Course course() {
        return course;
    }


    /**
     * Accept.
     */
    public void accept() {
        this.enrollState = EnrollmentState.ACCEPTED;
    }

    /**
     * Denied.
     */
    public void deny() {
        this.enrollState = EnrollmentState.DENIED;
    }

    public Long identity() {
        return this.idEnroll;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Enrollment)) {
            return false;
        }
        final Enrollment that = (Enrollment) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity()) && student.equals(that.student) && course.equals(that.course) && enrollState == that.enrollState;
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "idEnroll=" + idEnroll +
                ", enrollState=" + enrollState +
                ", student=" + student.identity() +
                ", course=" + course.identity() +
                '}';
    }
}
