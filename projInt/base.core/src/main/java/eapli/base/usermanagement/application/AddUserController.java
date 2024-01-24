/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.usermanagement.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.timetable.domain.TimeTable;
import eapli.base.timetable.repositories.TimetableRepository;
import eapli.base.user.builder.UserBuilder;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.domain.TaxNumber;
import eapli.base.student.domain.Student;
import eapli.base.student.service.StudentManagementService;
import eapli.base.teacher.domain.Acronym;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.service.TeacherManagementService;
import eapli.base.user.repositories.ECourseUserRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by nuno on 21/03/16.
 */
@UseCaseController
public class AddUserController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    private final ECourseUserRepository userRepository = PersistenceContext.repositories().eCourseUserRepository();
    private final TimetableRepository timetableRepository = PersistenceContext.repositories().timetableRepository();

    private final StudentManagementService studentSvc = new StudentManagementService();
    private final TeacherManagementService teacherSvc = new TeacherManagementService();
    private final UserBuilder userBuilder;

    /**
     * Instantiates a new Add user controller.
     */

    public AddUserController() {
        this.userBuilder = new UserBuilder();
    }


    /**
     * Get existing RoleTypes available to the user.
     *
     * @return a list of RoleTypes
     */
    public Role[] getRoleTypes() {
        return BaseRoles.nonUserValues();
    }

    /**
     * Add user system user.
     *
     * @param username  the username
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param roles     the roles
     * @param createdOn the created on
     * @return the system user
     */
    @Transactional
    public SystemUser addUser(final String username, final String password, final String firstName, final String lastName,
                              final String email, final Set<Role> roles, final Calendar createdOn) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.POWER_USER);

        return userSvc.registerNewUser(email, password, firstName, lastName, email, roles,
                createdOn);
    }

    /**
     * Add user system user.
     *
     * @param username  the username
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param roles     the roles
     * @return the system user
     */
    @Transactional
    public SystemUser addUser(final String username, final String password, final String firstName,
                              final String lastName, final String email, final Set<Role> roles) {
        return addUser(username, password, firstName, lastName, email, roles, CurrentTimeCalendars.now());
    }


    /**
     * Add student student.
     *
     * @param username            the username
     * @param password            the password
     * @param firstName           the first name
     * @param lastName            the last name
     * @param email               the email
     * @param roles               the roles
     * @param mecanographicNumber the mecanographic number
     * @param birthdate           the birthdate
     * @param taxNumber           the tax number
     * @return the student
     */
    @Transactional
    public Student addStudent(final String username, final String password, final String firstName,
                              final String lastName, final String email, final Set<Role> roles,
                              final MecanographicNumber mecanographicNumber, final Calendar birthdate, final TaxNumber taxNumber) {

        SystemUser systemUser;
        ECourseUser user;
        TimeTable timeTable = new TimeTable();
        timetableRepository.save(timeTable);
        try {
            systemUser = addUser(username, password, firstName, lastName, email, roles);
            user = userBuilder.withShortName(firstName).withEmail(email).withTaxNumber(taxNumber).withBirthDate(birthdate).withFullName(firstName, lastName).withTimeTable(timeTable).build();
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That username is already in use.");
            return null;
        }
        this.userRepository.save(user);
        Student student = studentSvc.registerNewStudent(mecanographicNumber, user, systemUser);
        System.out.println(student);
        System.out.println("Created");
        return student;
    }

    /**
     * Add teacher teacher.
     *
     * @param username  the username
     * @param password  the password
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param roles     the roles
     * @param acronym   the acronym
     * @param birthdate the birthdate
     * @param taxNumber the tax number
     * @return the teacher
     */
    @Transactional
    public Teacher addTeacher(final String username, final String password, final String firstName,
                              final String lastName, final String email, final Set<Role> roles,
                              final Acronym acronym, final Calendar birthdate, final TaxNumber taxNumber) {

        SystemUser systemUser;
        ECourseUser user;
        TimeTable timeTable = new TimeTable();
        timetableRepository.save(timeTable);
        try {
            systemUser = addUser(username, password, firstName, lastName, email, roles);
            user = userBuilder.withShortName(firstName).withEmail(email).withTaxNumber(taxNumber).withBirthDate(birthdate).withFullName(firstName, lastName).withTimeTable(timeTable).build();
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That username is already in use.");
            return null;
        }
        this.userRepository.save(user);
        Teacher teacher = teacherSvc.registerNewTeacher(acronym, user, systemUser);
        System.out.println(teacher);
        System.out.println("Created");

        return teacher;
    }

}
