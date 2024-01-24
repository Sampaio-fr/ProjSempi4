package eapli.base.examformative.domain;

import eapli.base.course.domain.Course;

import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

/**
 * The type Exam.
 */
@Entity
@Table
public class ExamFormative implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExamFormative")
    private Long idExamFormative;

    private String examTitle;

    @Column(name = "File", length = 2000)
    private String examStruct;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Teacher teacher;

    @Enumerated(EnumType.STRING)
    private FeedbackType feedbackType;

    @Enumerated(EnumType.STRING)
    private GradeType gradeType;

    public ExamFormative(String examTitle, String examStruct, Course course, Teacher teacher) {
        this.examTitle = examTitle;
        this.examStruct = examStruct;
        this.course = course;
        this.teacher = teacher;
        this.feedbackType = FeedbackType.ON_SUBMISSION;
        this.gradeType = GradeType.ON_SUBMISSION;
    }

    /**
     * Instantiates a new Exam.
     */
    protected ExamFormative() {
    }

    public String examStruct() {
        return examStruct;
    }

    public String title() {
        return examTitle;
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

    public void updateExamStruct(String struct){this.examStruct=struct;}

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof ExamFormative)) {
            return false;
        }
        final ExamFormative that = (ExamFormative) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity())
         && teacher.equals(that.teacher);
    }

    @Override
    public Long identity() {
        return idExamFormative;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "idExam=" + idExamFormative +
                ", course=" + course.identity() +
                '}';
    }
}

