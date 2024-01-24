package eapli.base.exam.domain;

import eapli.base.course.domain.Course;
import eapli.base.schedule.domain.Schedule;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Calendar;

/**
 * The type Exam.
 */
@Entity
public class Exam extends Schedule implements AggregateRoot<Long> {

    @Column(name = "State")
    @Enumerated(EnumType.STRING)
    private ExamState examState;

    private String title;

    /**
     * The Exam structor.
     */
    @Column(name = "File", length = 2000)
    String examStruct;
    @ManyToOne
    private Course course;

    @ManyToOne
    private Teacher teacher;

    @Enumerated(EnumType.STRING)
    private FeedbackType feedbackType;

    @Enumerated(EnumType.STRING)
    private GradeType gradeType;

    public Exam(ExamState examState, String title, String examStruct, Course course, Teacher teacher, FeedbackType feedbackType, GradeType gradeType) {
        super(Calendar.getInstance(), 0);
        this.examState = examState;
        this.title = title;
        this.examStruct = examStruct;
        this.course = course;
        this.teacher = teacher;
        this.feedbackType = feedbackType;
        this.gradeType = gradeType;
    }


    /**
     * Instantiates a new Exam.
     */
    protected Exam() {
    }


    /**
     * Gets exam type.
     *
     * @return the exam type
     */
    public ExamState examState() {
        return examState;
    }

    /**
     * Sets exam type.
     *
     * @param examState the exam type
     */
    public void changeExamState(ExamState examState) {
        this.examState = examState;
    }

    public String examTitle(){
        return this.title;
    }

    public void changeExamTitle(String title){
        this.title = title;
    }

    /**
     * Gets exam structor.
     *
     * @return the exam structor
     */
    public String examStruct() {
        return examStruct;
    }

    /**
     * Sets exam structor.
     *
     * @param examStructor the exam structor
     */
    public void changeExamStruct(String examStructor) {
        this.examStruct = examStructor;
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
     * Sets course.
     *
     * @param course the course
     */
    public void changeCourse(Course course) {
        this.course = course;
    }

    /**
     * Gets teacher.
     *
     * @return the teacher
     */
    public Teacher teacher() {
        return teacher;
    }

    /**
     * Sets teacher.
     *
     * @param teacher the teacher
     */
    public void changeTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void changeFeedbackType(FeedbackType feedbackType){this.feedbackType = feedbackType;}

    public void changeGradeType(GradeType gradeType){this.gradeType = gradeType;}

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Exam)) {
            return false;
        }
        final Exam that = (Exam) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity())
                && examStruct.equals(that.examStruct) && teacher.equals(that.teacher);
    }


    @Override
    public String toString() {
        return "Exam{ Title" + title +
                ", examStructor='" + examStruct + '\'' +
                ", course=" + course.identity() +
                '}';
    }
}