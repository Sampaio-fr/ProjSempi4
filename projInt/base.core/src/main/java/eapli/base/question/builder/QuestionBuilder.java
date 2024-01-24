package eapli.base.question.builder;

import eapli.base.course.domain.Course;
import eapli.base.question.domain.Question;
import eapli.base.question.domain.QuestionType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuestionBuilder {
    private static final Logger LOGGER = LogManager.getLogger(QuestionBuilder.class);
    private QuestionType questionType;
    private String question;
    private Course course;

    public QuestionBuilder withCourse(Course course) {
        this.course = course;
        return this;
    }

    public QuestionBuilder withQuestionType(QuestionType questionType) {
        this.questionType = questionType;
        return this;
    }

    public QuestionBuilder withQuestion(String question) {
        this.question = question;
        return this;
    }

    public Question build() {
        Question newQuestion = new Question(questionType, question, course);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating new question {}", newQuestion);
        }

        return newQuestion;
    }

}
