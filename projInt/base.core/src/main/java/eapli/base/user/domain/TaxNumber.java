package eapli.base.user.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.regex.Pattern;

/**
 * The type Tax number.
 *
 * @author InêsAlves (29/04/20023)
 */
public class TaxNumber implements ValueObject {

    private String taxNumber;

    /**
     * Instantiates a new Tax number.
     */
    protected TaxNumber() {
    }

    /**
     * Instantiates a new Tax number.
     *
     * @param taxNumber the tax number
     */
    public TaxNumber(final String taxNumber) {
        if (StringPredicates.isNullOrEmpty(taxNumber) || !taxNumberValidation(taxNumber)) {
            throw new IllegalArgumentException("Invalid Tax Number!!");
        }
        this.taxNumber = taxNumber;
    }

    /**
     * Value of tax number.
     *
     * @param taxNumber the tax number
     * @return the tax number
     */
    public static TaxNumber valueOf(final String taxNumber) {
        return new TaxNumber(taxNumber);
    }

    private boolean taxNumberValidation(final String taxNumber) {
        String regex = "[0-9]{9}";

        return Pattern.matches(regex, taxNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TaxNumber)) {
            return false;
        }

        final TaxNumber that = (TaxNumber) o;
        return this.taxNumber.equals(that.taxNumber);
    }

    @Override
    public int hashCode() {
        return this.taxNumber.hashCode();
    }

    @Override
    public String toString() {
        return this.taxNumber;
    }
}
