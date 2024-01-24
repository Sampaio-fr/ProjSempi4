package eapli.base.teacher.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Acronym.
 */
@Embeddable
public class Acronym implements ValueObject, Comparable<Acronym> {

    private String acronym;

    /**
     * Instantiates a new Acronym.
     */
    protected Acronym() {
    }

    /**
     * Instantiates a new Acronym.
     *
     * @param acronym the acronym
     */
    public Acronym(String acronym) {
        if (StringPredicates.isNullOrEmpty(acronym) || !acronymValidation(acronym)) {
            throw new IllegalArgumentException("Invalid Acronym");
        }
        this.acronym = acronym;
    }

    /**
     * Value of acronym.
     *
     * @param acronym the acronym
     * @return the acronym
     */
    public static Acronym valueOf(final String acronym) {
        return new Acronym(acronym);
    }

    private boolean acronymValidation(final String acronym) {
        String regex = "[A-Za-zÇ-ú]{1,20}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherNameCheck = pattern.matcher(acronym);

        return matcherNameCheck.find();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Acronym)) {
            return false;
        }

        final Acronym that = (Acronym) o;
        return this.acronym.equals(that.acronym);
    }

    @Override
    public int hashCode() {
        return this.acronym.hashCode();
    }

    @Override
    public int compareTo(final Acronym s) {
        return this.acronym.compareTo(s.acronym);
    }

    @Override
    public String toString() {
        return this.acronym;
    }
}
