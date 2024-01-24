package eapli.base.examformative.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

/**
 * The type Header.
 *
 * @author aliceresende (29-04-2022)
 */
@Entity
@Table
public class Header implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHeader;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "ExamDescription"))
    private Description examDescription;

    @Enumerated(EnumType.STRING)
    private FeedbackType examFeedBack;

    @Enumerated(EnumType.STRING)
    private GradeType examGrade;

    /**
     * Instantiates a new Header.
     *
     * @param examDescription the exam description
     * @param examFeedBack    the exam feed back
     * @param examGrade       the exam grade
     */
    public Header(final Description examDescription, final FeedbackType examFeedBack, final GradeType examGrade) {
        Preconditions.noneNull(examDescription, examFeedBack, examGrade);
        this.examDescription = examDescription;
        this.examFeedBack = FeedbackType.NONE;
        this.examGrade = GradeType.NONE;
    }

    /**
     * Instantiates a new Header.
     */
    protected Header() {
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Header)) {
            return false;
        }

        final Header that = (Header) other;
        if (this == that) {
            return true;
        }

        return identity().equals(that.identity()) && examDescription.equals(that.examDescription) && examFeedBack == that.examFeedBack && examGrade == that.examGrade;
    }

    public Description getExamDescription() {
        return examDescription;
    }

    public void setExamDescription(Description examDescription) {
        this.examDescription = examDescription;
    }

    public FeedbackType getExamFeedBack() {
        return examFeedBack;
    }

    public void setExamFeedBack(FeedbackType examFeedBack) {
        this.examFeedBack = examFeedBack;
    }

    public GradeType getExamGrade() {
        return examGrade;
    }

    public void setExamGrade(GradeType examGrade) {
        this.examGrade = examGrade;
    }

    /**
     * Feed back after closing.
     */
    public void feedBackAfterClosing() {
        this.examFeedBack = FeedbackType.AFTER_CLOSING;
    }

    /**
     * Feed back on submission.
     */
    public void feedBackOnSubmission() {
        this.examFeedBack = FeedbackType.ON_SUBMISSION;
    }

    /**
     * Grade after closing.
     */
    public void gradeAfterClosing() {
        this.examGrade = GradeType.AFTER_CLOSING;
    }

    /**
     * Grade on submission.
     */
    public void gradeOnSubmission() {
        this.examGrade = GradeType.ON_SUBMISSION;
    }

    @Override
    public Long identity() {
        return this.idHeader;
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
        return "Header{" +
                "idHeader=" + idHeader +
                ", examDescription=" + examDescription +
                ", examFeedBack=" + examFeedBack +
                ", examGrade=" + examGrade +
                '}';
    }

}
