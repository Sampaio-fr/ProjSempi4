package eapli.base.user.domain;

import javax.persistence.*;
import java.util.Calendar;

import eapli.base.timetable.domain.TimeTable;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;


/**
 * The type ECourseUser.
 */
@Entity
@Table
public class ECourseUser implements AggregateRoot<EmailAddress> {

    @Id
    @Column(name = "id")
    private EmailAddress email;


    @Column(name = "SHORT_NAME")
    @Embedded
    private ShortName shortName;

    @Column(name = "FULL_NAME")
    @Embedded
    private FullName fullName;

    @Column(name = "BIRTH_DATE")
    private Calendar birthDate;

    @Column(name = "TAX_NUMBER", unique = true)
    @Embedded
    private TaxNumber taxNumber;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private TimeTable timeTable;


    /**
     * Instantiates a new ECourseUser.
     */
    protected ECourseUser() {
    }

    /**
     * Instantiates a new ECourseUser.
     *
     * @param email     the login
     * @param shortName the short name
     * @param fullName  the full name
     * @param birthDate the birthdate
     * @param taxNumber the tax number
     */
    public ECourseUser(EmailAddress email, ShortName shortName, FullName fullName, Calendar birthDate, TaxNumber taxNumber,TimeTable timeTable) {
        Preconditions.noneNull(shortName, fullName, birthDate, taxNumber);
        this.email = email;
        this.shortName = shortName;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.taxNumber = taxNumber;
        this.timeTable = timeTable;
    }

    public EmailAddress email() {
        return email;
    }

    public TimeTable timeTable() {
        return timeTable;
    }

    public void replaceTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }

    public ShortName shortName() {
        return shortName;
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public EmailAddress identity() {
        return this.email;
    }

    @Override
    public String toString() {
        return "ECourseUser:" + "\n" +
                "Id =" + email + "\n" +
                "ShortName =" + shortName + "\n" +
                "FullName =" + fullName + "\n" +
                "BirthDate =" + birthDate.getTime() + "\n" +
                "TaxNumber =" + taxNumber + "\n";
    }
}
