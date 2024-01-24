package eapli.base.teacher.service;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.teacher.domain.Acronym;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.domain.TeacherBuilder;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.base.timetable.domain.TimeTable;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.transaction.annotation.Transactional;


/**
 * The type Create teacher service.
 */
public class TeacherManagementService {

    private final TeacherRepository teacherRepository = PersistenceContext.repositories().teacherRepository();

    /**
     * Register new teacher.
     *
     * @param systemUser the system user
     * @return the teacher
     */
    @Transactional
    public Teacher registerNewTeacher(final Acronym acronym, final ECourseUser user, final SystemUser systemUser) {
        TeacherBuilder teacherBuilder = new TeacherBuilder();
        teacherBuilder.withAcronym(acronym).withUser(user).withSystemUser(systemUser);
        Teacher newTeacher = teacherBuilder.build();
        return this.teacherRepository.save(newTeacher);
    }

    /**
     * All teachers registered iterable.
     *
     * @return the iterable
     */
    public Iterable<Teacher> allTeachers() {
        return teacherRepository.findAll();
    }



}
