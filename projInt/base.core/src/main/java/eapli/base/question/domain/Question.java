package eapli.base.question.domain;

import eapli.base.course.domain.Course;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

/**
 * The type Question.
 *
 * @author aliceresende (29-04-2022)
 */
@Entity
@Table
public class Question implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idQuestion;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @Column(name = "question")
    private String question;

    @OneToOne
    private Course questionCourse;

    /**
     * Instantiates a new Question.
     */
    protected Question() {
    }

    /**
     * Instantiates a new Question.
     *
     * @param questionType   the question type
     * @param question       the question
     * @param questionCourse the question course
     */
    public Question(QuestionType questionType, String question,Course questionCourse) {
        Preconditions.noneNull(questionType, question);
        this.questionType = questionType;
        this.question = question;
        this.questionCourse = questionCourse;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Question)) {
            return false;
        }

        final Question that = (Question) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity()) && questionType == that.questionType && questionCourse.equals(that.questionCourse);
    }

    public void matching(){
        this.questionType=QuestionType.MATCHING;
    }
    public void numerical(){
        this.questionType=QuestionType.NUMERICAL;
    }
    public void missing_words(){
        this.questionType=QuestionType.MISSING_WORDS;
    }
    public void short_answer(){
        this.questionType=QuestionType.SHORT_ANSWER;
    }
    public void multiple_choice(){
        this.questionType=QuestionType.MULTIPLE_CHOICE;
    }
    public void true_false(){
        this.questionType=QuestionType.TRUE_FALSE;
    }
    public QuestionType defineQuestionType(String s){
        this.questionType =QuestionType.defineFromString(s);
        return QuestionType.defineFromString(s);
    }

    /**
     * Sets question.
     *
     * @param question the question
     */
    public void changeQuestion(String question) {
        this.question = question;
    }

    /**
     * Sets question course.
     *
     * @param questionCourse the question course
     */
    public void changeQuestionCourse(Course questionCourse) {
        this.questionCourse = questionCourse;
    }

    /**
     * Gets question type.
     *
     * @return the question type
     */
    public QuestionType questionType() {
        return questionType;
    }

    /**
     * Gets question.
     *
     * @return the question
     */
    public String question() {
        return question;
    }

    /**
     * Gets question course.
     *
     * @return the question course
     */
    public Course questionCourse() {
        return questionCourse;
    }

    @Override
    public Long identity() {
        return this.idQuestion;
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
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", questionType=" + questionType +
                ", question='" + question + '\'' +
                ", questionCourse=" + questionCourse +
                '}';
    }
}

