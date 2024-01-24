package eapli.base.teacher.domain;

import eapli.base.user.domain.ECourseUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;


/**
 * The type Teacher.
 */
@Entity
@Table
public class Teacher implements AggregateRoot<Acronym> {

    @Id
    @Column(name = "acronym", unique = true)
    private Acronym acronym;

    @OneToOne
    private ECourseUser user;

    @OneToOne
    private SystemUser systemUser;

    /**
     * Instantiates a new Teacher.
     */
    protected Teacher() {
    }

    /**
     * Instantiates a new Teacher.
     *
     * @param acronym the acronym
     * @param login   the login
     * @param user    the short name
     */
    public Teacher(Acronym acronym, final SystemUser login, ECourseUser user) {
        this.systemUser = login;
        this.user = user;
        this.acronym = acronym;
    }


    /**
     * Gets acronym.
     *
     * @return the acronym
     */
    public Acronym acronym() {
        return acronym;
    }

    /**
     * Sets acronym.
     *
     * @param acronym the acronym
     */
    public void changeAcronym(Acronym acronym) {
        this.acronym = acronym;
    }



    /**
     * Gets user.
     *
     * @return the user
     */
    public ECourseUser user() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void changeUser(ECourseUser user) {
        this.user = user;
    }

    /**
     * Gets system user.
     *
     * @return the system user
     */
    public SystemUser systemUser() {
        return systemUser;
    }

    /**
     * Sets system user.
     *
     * @param systemUser the system user
     */
    public void changeSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }


    public Acronym identity() {
        return acronym;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public String toString() {
        return "Teacher:" + "\n" +
                "Acronym = " + acronym + "\n" +
                "Email = " + user.email() + "\n";
    }
}
