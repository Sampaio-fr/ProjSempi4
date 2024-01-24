package eapli.base.user.builder;


import eapli.base.timetable.domain.TimeTable;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.domain.FullName;
import eapli.base.user.domain.ShortName;
import eapli.base.user.domain.TaxNumber;
import eapli.framework.general.domain.model.EmailAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;

/**
 * The type CourseUser builder.
 */
public class UserBuilder {
    private static final Logger LOGGER = LogManager.getLogger(UserBuilder.class);
    private EmailAddress emailAddress;
    private FullName fullName;
    private ShortName shortName;
    private Calendar birthDate;

    private TaxNumber taxNumber;
    private TimeTable timeTable;

    /**
     * With full name user builder.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @return the user builder
     */
    public UserBuilder withFullName(final String firstName, final String lastName) {
        this.fullName = new FullName(firstName, lastName);
        return this;
    }

    /**
     * With full name user builder.
     *
     * @param fullName the full name
     * @return the user builder
     */
    public UserBuilder withFullName(final FullName fullName) {
        this.fullName = fullName;
        return this;
    }


    /**
     * With email user builder.
     *
     * @param emailAddress the email address
     * @return the user builder
     */
    public UserBuilder withEmail(final EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * With email user builder.
     *
     * @param emailAddress the email address
     * @return the user builder
     */
    public UserBuilder withEmail(final String emailAddress) {
        this.emailAddress = EmailAddress.valueOf(emailAddress);
        return this;
    }

    /**
     * With short name user builder.
     *
     * @param name the name
     * @return the user builder
     */
    public UserBuilder withShortName(final String name) {
        this.shortName = new ShortName(name);
        return this;
    }

    /**
     * With short name user builder.
     *
     * @param shortName the short name
     * @return the user builder
     */
    public UserBuilder withShortName(final ShortName shortName) {
        this.shortName = shortName;
        return this;
    }


    /**
     * With birth date user builder.
     *
     * @param birthDate the birth date
     * @return the user builder
     */
    public UserBuilder withBirthDate(final Calendar birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * With tax number user builder.
     *
     * @param taxNumber the tax number
     * @return the user builder
     */
    public UserBuilder withTaxNumber(final TaxNumber taxNumber) {
        this.taxNumber = taxNumber;
        return this;
    }

    /**
     * With tax number user builder.
     *
     * @param taxNumber the tax number
     * @return the user builder
     */
    public UserBuilder withTaxNumber(final String taxNumber) {
        this.taxNumber = new TaxNumber(taxNumber);
        return this;
    }

    public UserBuilder withTimeTable(final TimeTable timeTable) {
        this.timeTable = timeTable;
        return this;
    }

    /**
     * Build user.
     *
     * @return the user
     */
    public ECourseUser build() {
        ECourseUser user = new ECourseUser(this.emailAddress, this.shortName, this.fullName, this.birthDate, this.taxNumber,this.timeTable);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating new user {} {} {} {} with system info ", this.fullName, this.shortName, this.taxNumber, this.birthDate);
        }

        return user;
    }


}
