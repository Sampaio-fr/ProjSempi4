package eapli.base.student.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.timetable.domain.TimeTable;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Student builder.
 */
public class StudentBuilder {

    private static final Logger LOGGER = LogManager.getLogger(StudentBuilder.class);
    private SystemUser systemUser;

    private MecanographicNumber mecanographicNumber;
    private ECourseUser user;


    /**
     * With mecanographic number student builder.
     *
     * @param mecanographicNumber the mecanographic number
     * @return the student builder
     */
    public StudentBuilder withMecanographicNumber(final String mecanographicNumber) {
        this.mecanographicNumber = new MecanographicNumber(mecanographicNumber);
        return this;
    }

    /**
     * With mecanographic number student builder.
     *
     * @param mecanographicNumber the mecanographic number
     * @return the student builder
     */
    public StudentBuilder withMecanographicNumber(final MecanographicNumber mecanographicNumber) {
        this.mecanographicNumber = mecanographicNumber;
        return this;
    }

    /**
     * With system user student builder.
     *
     * @param systemUser the system user
     * @return the student builder
     */
    public StudentBuilder withSystemUser(final SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }


    /**
     * Build student.
     *
     * @return the student
     */
    public Student build() {
        Student student = new Student(mecanographicNumber,systemUser,user);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating new student [{}] {} {} {} with system info ", student, this.mecanographicNumber, this.user, this.systemUser);
        }

        return student;
    }

    /**
     * With user student builder.
     *
     * @param user the user
     * @return the student builder
     */
    public StudentBuilder withUser(ECourseUser user) {
        this.user = user;
        return this;
    }
}
