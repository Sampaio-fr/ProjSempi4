package eapli.base.question.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

/**
 * The type Answer.
 */
public class Answer implements ValueObject {

    private String answer;

    /**
     * Instantiates a new Answer.
     *
     * @param answer the answer
     */
    public Answer(String answer) {
        Preconditions.nonEmpty(answer, "Answer should not be empty");
        this.answer = answer;
    }

    /**
     * Instantiates a new Answer.
     */
    protected Answer() {
    }

    /**
     * Value of answer.
     *
     * @param answer the answer
     * @return the answer
     */
    public static Answer valueOf(final String answer) {
        return new Answer(answer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Answer that = (Answer) o;
        return this.answer.equals(that.answer);
    }

    @Override
    public int hashCode() {
        return this.answer.hashCode();
    }

    @Override
    public String toString() {
        return answer;
    }
}
