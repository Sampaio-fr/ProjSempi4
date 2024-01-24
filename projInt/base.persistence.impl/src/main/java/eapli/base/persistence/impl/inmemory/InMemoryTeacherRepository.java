package eapli.base.persistence.impl.inmemory;

import eapli.base.teacher.domain.Acronym;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryTeacherRepository extends InMemoryDomainRepository<Teacher, Acronym> implements TeacherRepository {
    @Override
    public Teacher teacherByUsername(EmailAddress email) {
        return null;
    }

    @Override
    public Teacher findTeacherByEmail(EmailAddress email){ return null; }

    @Override
    public Iterable<Teacher> searchUsersavailable() {
        return null;
    }

    @Override
    public Iterable<Teacher> myDetails(SystemUser user) {
        return null;
    }


}
