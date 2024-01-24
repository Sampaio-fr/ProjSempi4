package eapli.base.user.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * The type Full name.
 */
@Embeddable
public class FullName implements ValueObject, Comparable<FullName> {

    private String firstName;
    private String lastName;
    private static final Pattern VALID_NAME_REGEX = Pattern.compile("^[A-Z][a-zA-Z ',.\\-]*$", 2);

    /**
     * Instantiates a new Full name.
     */
    protected FullName() {
    }

    /**
     * Instantiates a new Full name.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public FullName(String firstName, String lastName) {
        Preconditions.nonEmpty(firstName, "First name should neither be null nor empty");
        Preconditions.nonEmpty(lastName, "Last name should neither be null nor empty");
        Preconditions.matches(VALID_NAME_REGEX, firstName, "Invalid First Name: " + firstName);
        Preconditions.matches(VALID_NAME_REGEX, lastName, "Invalid Last Name: " + lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Value of full name.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @return the full name
     */
    public static FullName valueOf(final String firstName, final String lastName) {
        return new FullName(firstName, lastName);
    }

    /**
     * First name string.
     *
     * @return the string
     */
    public String firstName() {
        return this.firstName;
    }

    /**
     * Last name string.
     *
     * @return the string
     */
    public String lastName() {
        return this.lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(firstName, fullName.firstName) && Objects.equals(lastName, fullName.lastName);
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object $firstName = this.firstName();
        result = result * 59 + ($firstName == null ? 43 : $firstName.hashCode());
        Object $lastName = this.lastName();
        result = result * 59 + ($lastName == null ? 43 : $lastName.hashCode());
        return result;
    }

    @Override
    public int compareTo(FullName o) {
        return 0;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
