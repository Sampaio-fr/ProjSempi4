package eapli.base.exam.builder;

import eapli.base.course.domain.Course;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.domain.ExamState;
import eapli.base.exam.domain.FeedbackType;
import eapli.base.exam.domain.GradeType;
import eapli.base.teacher.domain.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Meeting builder.
 */
public class ExamBuilder {

    private static final Logger LOGGER = LogManager.getLogger(ExamBuilder.class);

    private ExamState examState;
    private String title;
    private String examStruct;
    private Course course;
    private Teacher teacher;
    private FeedbackType feedbackType;
    private GradeType gradeType;


    /**
     * Withexam state exam builder.
     *
     * @param examState the exam state
     * @return the exam builder
     */
    public ExamBuilder withExamState(ExamState examState) {
        this.examState = examState;
        return this;
    }

    /**
     * With course exam builder.
     *
     * @param course the course
     * @return the exam builder
     */
    public ExamBuilder withCourse(Course course) {
        this.course = course;
        return this;
    }

    public ExamBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * With exam struct exam builder.
     *
     * @param examStruct the exam struct
     * @return the exam builder
     */
    public ExamBuilder withExamStruct(String examStruct) {
        this.examStruct = examStruct;
        return this;
    }


    /**
     * With teacher exam builder.
     *
     * @param teacher the teacher
     * @return the exam builder
     */
    public ExamBuilder withTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }


    /**
     * With feedback type exam builder.
     *
     * @param feedbackType the feedback type
     * @return the exam builder
     */
    public ExamBuilder withFeedbackType(FeedbackType feedbackType) {
        this.feedbackType = feedbackType;
        return this;
    }

    /**
     * With grade type exam builder.
     *
     * @param gradeType the grade type
     * @return the exam builder
     */
    public ExamBuilder withGradeType(GradeType gradeType) {
        this.gradeType = gradeType;
        return this;
    }

    /**
     * Instantiates a new Exam builder.
     */
    public ExamBuilder() {
    }


    /**
     * Build exam.
     *
     * @return the exam
     */
    public Exam build() {
        Exam exam = new Exam(this.examState, this.title, this.examStruct, this.course, this.teacher, this.feedbackType, this.gradeType);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating new Exam {}  with system info ", this.examState);
        }

        return exam;
    }

}
