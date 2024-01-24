package eapli.base.teacherInCharge.domain;


import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;


/**
 * The type Teacher.
 */
@Entity
@Table
public class TeacherInCharge implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Teacher teacher;

    /**
     * Instantiates a new Teacher.
     */
    protected TeacherInCharge() {
    }

    /**
     * Instantiates a new Teacher.
     *
     * @param teacher the atributed teacher
     */
    public TeacherInCharge(Teacher teacher) {
        this.teacher = teacher;
    }


    public Teacher teacher() {
        return this.teacher;
    }


    public void changeTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }


    public Long identity() {
        return id;
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
        return "TeacherInCharge{" +
                "id=" + id +
                ", teacher=" + teacher +
                '}';
    }
}
