package eapli.base.user.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * The type Short name.
 *
 * @author InêsAlves (29/04/20023)
 */
@Embeddable
public class ShortName implements ValueObject, Comparable<ShortName> {

    private String shortName;

    /**
     * Instantiates a new Short name.
     */
    protected ShortName() {
    }

    /**
     * Instantiates a new Short name.
     *
     * @param shortName the short name
     */
    public ShortName(String shortName) {
        if (StringPredicates.isNullOrEmpty(shortName) || !shortNameValidation(shortName)) {
            throw new IllegalArgumentException("The user short name must have 1 to 20 chars!!");
        }
        this.shortName = shortName;
    }

    /**
     * Value of short name.
     *
     * @param shortName the short name
     * @return the short name
     */
    public static ShortName valueOf(final String shortName) {
        return new ShortName(shortName);
    }

    private boolean shortNameValidation(final String shortName) {
        String regex = "[A-Za-zÇ-ú]{1,20}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherNameCheck = pattern.matcher(shortName);

        return matcherNameCheck.find();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ShortName)) {
            return false;
        }

        final ShortName that = (ShortName) o;
        return this.shortName.equals(that.shortName);
    }


    @Override
    public int hashCode() {
        return this.shortName.hashCode();
    }

    @Override
    public int compareTo(final ShortName s) {
        return this.shortName.compareTo(s.shortName);
    }

    @Override
    public String toString() {
        return this.shortName;
    }
}
