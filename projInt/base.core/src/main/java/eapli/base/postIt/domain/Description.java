package eapli.base.postIt.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

/**
 * The type Description.
 */
public class Description implements ValueObject {

    private String description;

    /**
     * Instantiates a new Description.
     *
     * @param description the description
     */
    public Description(String description) {
        this.description = description;
    }
    protected Description() {

    }

    /**
     * Description string.
     *
     * @return the string
     */
    public String description() {
        return description;
    }

    /**
     * Replace description.
     *
     * @param description the description
     */
    public void replaceDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return description;
    }
}
