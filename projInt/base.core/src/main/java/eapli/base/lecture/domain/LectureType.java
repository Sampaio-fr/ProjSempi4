package eapli.base.lecture.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Table;

/**
 * The enum Lecture type.
 *
 * @author Inês Alves (29/04/2023)
 */
public enum LectureType implements ValueObject {
    /**
     * Normal lecture type.
     */
    NORMAL,
    /**
     * Extra lecture type.
     */
    EXTRA
}
