package eapli.base.teacher.domain;

import eapli.base.student.domain.StudentBuilder;
import eapli.base.timetable.domain.TimeTable;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Teacher builder.
 */
public class TeacherBuilder implements DomainFactory<Teacher> {

    private static final Logger LOGGER = LogManager.getLogger(TeacherBuilder.class);
    private SystemUser systemUser;
    private Acronym acronym;
    private ECourseUser user;


    /**
     * With acronym teacher builder.
     *
     * @param acronym the acronym
     * @return the teacher builder
     */
    public TeacherBuilder withAcronym(final String acronym) {
        this.acronym = new Acronym(acronym);
        return this;
    }

    /**
     * With acronym teacher builder.
     *
     * @param acronym the acronym
     * @return the teacher builder
     */
    public TeacherBuilder withAcronym(final Acronym acronym) {
        this.acronym = acronym;
        return this;
    }

    /**
     * With system user teacher builder.
     *
     * @param systemUser the system user
     * @return the teacher builder
     */
    public TeacherBuilder withSystemUser(final SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }


    /**
     * With user teacher builder.
     *
     * @param user the user
     * @return the teacher builder
     */
    public TeacherBuilder withUser(ECourseUser user) {
        this.user = user;
        return this;
    }


    public Teacher build() {
        Teacher teacher = new Teacher(acronym, systemUser, user);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating new teacher [{}] {} {} {} with system info ", teacher, this.acronym, this.user, this.systemUser);
        }

        return teacher;
    }


}
