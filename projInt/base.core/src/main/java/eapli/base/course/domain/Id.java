package eapli.base.course.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class Id implements ValueObject, Comparable<Id> {
    private String id;

    /**
     * Instantiates a new Id.
     *
     * @param id the id
     */
    public Id(final String id) {
        if (StringPredicates.isNullOrEmpty(id) || !validCourseId(id)) {
            throw new IllegalArgumentException(
                    "Invalid Course ID!");
        }
        this.id = id;
    }

    /**
     * Instantiates a new Id.
     */
    protected Id() {
    }

    /**
     * Value of id.
     *
     * @param id the id
     * @return the id
     */
    public static Id valueOf(final String id) {
        return new Id(id);
    }

    private boolean validCourseId(String id) {
        return id.length() < 50;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Id)) return false;
        final Id that = (Id) o;
        return this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public int compareTo(Id o) {
        return this.id.compareTo(o.id);
    }
}
