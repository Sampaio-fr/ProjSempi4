package eapli.base.student.domain;


import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.enrollment.domain.Enrollment;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Student.
 */
@Entity
@Table
public class Student implements AggregateRoot<MecanographicNumber> {

    @Id
    @Column(name = "mechanographic_number", unique = true)
    private MecanographicNumber mechanographic;

    @OneToOne
    private ECourseUser user;

    @OneToOne
    private SystemUser systemUser;
    @OneToMany
    private List<Enrollment> courses;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Grade> gradeList;

    /**
     * Instantiates a new Student.
     */
    protected Student() {
    }

    /**
     * Instantiates a new Student.
     *
     * @param mechanographic the mechanographic
     * @param login          the login
     * @param user           the user
     */
    public Student(MecanographicNumber mechanographic, final SystemUser login, ECourseUser user) {
        this.systemUser = login;
        this.user = user;
        this.courses = new ArrayList<>();
        this.mechanographic = mechanographic;
        this.gradeList = new ArrayList<>();
    }

    /**
     * Gets courses.
     *
     * @return the courses
     */
    public List<Enrollment> courses() {
        return courses;
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


    /**
     * Gets courses.
     *
     * @return the courses
     */
    public List<Enrollment> findEnrollments() {
        return courses;
    }

    /**
     * Add course boolean.
     *
     * @param course the course
     * @return the boolean
     */
    public boolean addEnrollment(Enrollment course) {
        return courses.add(course);
    }

    /**
     * Sets courses.
     *
     * @param courses the courses
     */
    public void changeCourses(List<Enrollment> courses) {
        this.courses = courses;
    }

    public boolean addGrade(Grade grade) {
        return this.gradeList.add(grade);
    }

    @Override
    public boolean sameAs(Object other) {

        return DomainEntities.areEqual(this, other);
    }

    @Override
    public MecanographicNumber identity() {
        return this.mechanographic;
    }

    public List<Grade> getGradeList() {
        return this.gradeList;
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
        return "Student:" + "\n" +
                "Mechanographic Number = " + mechanographic + "\n" +
                systemUser.identity() + "\n" +
                "Enrollments = " + courses + "\n";
    }
}
