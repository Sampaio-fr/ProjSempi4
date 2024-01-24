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
package eapli.base.student.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.course.domain.Course;
import eapli.base.student.domain.Student;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.List;

/**
 * The interface Student repository.
 *
 * @author
 */
public interface StudentRepository extends DomainRepository<MecanographicNumber, Student> {

    /**
     * Courses by student list.
     *
     * @param student the student
     * @return the list
     */
    List<Course> coursesByStudent(final Student student);

    Student findStudentByEmail(final EmailAddress email);

    Iterable<Student> studentByUsername(Username username);

    List<Student> getStudentFromMecNumber(MecanographicNumber mecNum);

    Iterable<Student>  searchUsersavailable();
}
