package eapli.base.student.domain;

import eapli.base.course.domain.Course;
import eapli.base.exam.domain.Exam;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
@Table
public class Grade implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Course course;
    @OneToOne
    private Exam exam;
    private int examGrade;
    private float myGrade;
    private float percentage;

    protected Grade() {
    }

    public Grade(Course course, Exam exam, int examGrade, float myGrade) {
        Preconditions.noneNull(course, exam, examGrade, myGrade);

        this.course = course;
        this.exam = exam;
        this.examGrade = examGrade;
        this.myGrade = myGrade;
        this.percentage = (myGrade / examGrade) * 100;
    }

    public Course findGradeCourse(){
        return this.course;
    }

    public Exam findGradeExams(){
        return this.exam;
    }

    public Float retrieveStudentGrade(){
        return this.myGrade;
    }

    public int retrieveExamGrade(){
        return this.examGrade;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Grade)) {
            return false;
        }
        final Grade that = (Grade) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity()) && course.equals(that.course) && exam.equals(that.exam) &&
                examGrade == that.examGrade && myGrade == that.myGrade;
    }

    @Override
    public Long identity() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", course=" + course +
                ", exam=" + exam +
                ", examGrade=" + examGrade +
                ", myGrade=" + myGrade +
                ", percentage=" + percentage +
                '}';
    }
}
