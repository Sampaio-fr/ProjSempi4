package eapli.base.course.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.StringMixin;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The type Edition.
 *
 */
@Embeddable
public class Code implements ValueObject, Comparable<Code>, Serializable, StringMixin {


    private String edition;

    /**
     * Instantiates a new Edition.
     *
     * @param edition the edition
     */
    public Code(String edition) {
      if (StringPredicates.isNullOrEmpty(edition)) {
            throw new IllegalArgumentException("Invalid course edition. Please enter a valid edition in the format 'courseLevel-courseName-semesterNumber'.");
        }
        this.edition = edition;
    }

    /**
     * Instantiates a new Edition.
     */
    protected Code() {
    }

    /**
     * Value of edition.
     *
     * @param edition the edition
     * @return the edition
     */
    public static Code valueOf(final String edition) {
        return new Code(edition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Code)) return false;
        final Code that = (Code) o;
        return this.edition.equals(that.edition);
    }

    @Override
    public int hashCode() {
        return this.edition.hashCode();
    }

    @Override
    public String toString() {
        return this.edition;
    }

    @Override
    public int compareTo(Code o) {
        return this.edition.compareTo(o.edition);
    }
}
