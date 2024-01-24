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
package eapli.base.infrastructure.persistence;

import eapli.base.CellLog.repositories.CellLogRepository;
import eapli.base.PostItLog.repositories.PostItLogRepository;
import eapli.base.SharedBoardLog.repositories.SharedBoardLogRepository;
import eapli.base.cell.repositories.CellRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.enrollment.repositories.EnrollmentRepository;
import eapli.base.enrollmentapproval.repositories.EnrollmentApprovalRepository;
import eapli.base.exam.repositories.ExamRepository;
import eapli.base.examformative.repositories.ExamFormativeRepository;
import eapli.base.lecture.repositories.LecturesRepository;
import eapli.base.meeting.repositories.MeetingRepository;
import eapli.base.notificationMeeting.repositories.NotificationRepository;
import eapli.base.participant.repositories.ParticipantRepository;
import eapli.base.permission.repositories.PermissionRepository;
import eapli.base.postIt.repositories.PostItRepository;
import eapli.base.question.repositories.QuestionRepository;
import eapli.base.schedule.repositories.ScheduleRepository;
import eapli.base.sharedBoard.repositories.SharedBoardRepository;
import eapli.base.student.repositories.GradeRepository;
import eapli.base.student.repositories.StudentRepository;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.base.teacherInCharge.repositories.TeacherInChargeRepository;
import eapli.base.timetable.repositories.TimetableRepository;
import eapli.base.user.repositories.ECourseUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;

/**
 * The interface Repository factory.
 *
 * @author Paulo Gandra Sousa
 */
public interface RepositoryFactory {

    /**
     * Exam formative repository exam formative repository.
     *
     * @param autoTx the auto tx
     * @return the exam formative repository
     */
    ExamFormativeRepository examFormativeRepository(TransactionalContext autoTx);

    /**
     * Exam formative repository exam formative repository.
     *
     * @return the exam formative repository
     */
    ExamFormativeRepository examFormativeRepository();


    /**
     * E course user repository e course user repository.
     *
     * @return the e course user repository
     */
    ECourseUserRepository eCourseUserRepository();

    /**
     * E course user repository e course user repository.
     *
     * @param autoTx the auto tx
     * @return the e course user repository
     */
    ECourseUserRepository eCourseUserRepository(TransactionalContext autoTx);

    /**
     * Notification repository notification repository.
     *
     * @return the notification repository
     */
    NotificationRepository notificationRepository();

    /**
     * Notification repository notification repository.
     *
     * @param autoTx the auto tx
     * @return the notification repository
     */
    NotificationRepository notificationRepository(TransactionalContext autoTx);

    /**
     * Participant repository participant repository.
     *
     * @return the participant repository
     */
    ParticipantRepository participantRepository();

    /**
     * Participant repository participant repository.
     *
     * @param autoTx the auto tx
     * @return the participant repository
     */
    ParticipantRepository participantRepository(TransactionalContext autoTx);

    /**
     * Cell repository cell repository.
     *
     * @param tx the tx
     * @return the cell repository
     */
    CellRepository cellRepository(TransactionalContext tx);

    /**
     * Enrollment approval repository enrollment approval repository.
     *
     * @return the enrollment approval repository
     */
    EnrollmentApprovalRepository enrollmentApprovalRepository();

    /**
     * Enrollment approval r repository enrollment approval repository.
     *
     * @param autoTx the auto tx
     * @return the enrollment approval repository
     */
    EnrollmentApprovalRepository enrollmentApprovalRepository(TransactionalContext autoTx);

    SharedBoardLogRepository sharedBoardLogRepository();

    SharedBoardLogRepository sharedBoardLogRepository(TransactionalContext autoTx);

    PostItLogRepository postItLogRepository();

    PostItLogRepository postItLogRepository(TransactionalContext autoTx);

    CellLogRepository cellLogRepository();

    CellLogRepository cellLogRepository(TransactionalContext autoTx);

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return transactional context
     */
    TransactionalContext newTransactionalContext();

    /**
     * Users eapli . framework . infrastructure . authz . domain . repositories . user repository.
     *
     * @param autoTx the transactional context to enrol
     * @return eapli . framework . infrastructure . authz . domain . repositories . user repository
     */
    eapli.framework.infrastructure.authz.domain.repositories.UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return eapli . framework . infrastructure . authz . domain . repositories . user repository
     */
    eapli.framework.infrastructure.authz.domain.repositories.UserRepository users();


    /**
     * Timetable repository timetable repository.
     *
     * @param autoTx the auto tx
     * @return the timetable repository
     */
    TimetableRepository timetableRepository(TransactionalContext autoTx);

    /**
     * Timetable repository timetable repository.
     *
     * @return the timetable repository
     */
    TimetableRepository timetableRepository();

    /**
     * Client users client user repository.
     *
     * @param autoTx the transactional context to enroll
     * @return client user repository
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return client user repository
     */
    ClientUserRepository clientUsers();

    /**
     * Signup requests signup request repository.
     *
     * @param autoTx the transactional context to enroll
     * @return signup request repository
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return signup request repository
     */
    SignupRequestRepository signupRequests();


    /**
     * Question repository question repository.
     *
     * @return the question repository
     */
    QuestionRepository questionRepository();

    /**
     * Question repository question repository.
     *
     * @param autoTx the auto tx
     * @return the question repository
     */
    QuestionRepository questionRepository(TransactionalContext autoTx);

    /**
     * Course repository course repository.
     *
     * @return the course repository
     */
    CourseRepository courseRepository();

    /**
     * Course repository course repository.
     *
     * @param autoTx the auto tx
     * @return the course repository
     */
    CourseRepository courseRepository(TransactionalContext autoTx);

    /**
     * Meeting repository meeting repository.
     *
     * @param autoTx the auto tx
     * @return the meeting repository
     */
    MeetingRepository meetingRepository(TransactionalContext autoTx);

    /**
     * Meeting repository meeting repository.
     *
     * @return the meeting repository
     */
    MeetingRepository meetingRepository();

    /**
     * Teacher repository teacher repository.
     *
     * @return the teacher repository
     */
    TeacherRepository teacherRepository();

    /**
     * Teacher repository teacher repository.
     *
     * @param autoTx the auto tx
     * @return the teacher repository
     */
    TeacherRepository teacherRepository(TransactionalContext autoTx);

    /**
     * Teacher in charge repository teacher in charge repository.
     *
     * @return the teacher in charge repository
     */
    TeacherInChargeRepository teacherInChargeRepository();

    /**
     * Teacher in charge repository teacher in charge repository.
     *
     * @param autoTx the auto tx
     * @return the teacher in charge repository
     */
    TeacherInChargeRepository teacherInChargeRepository(TransactionalContext autoTx);

    /**
     * Schedule repository schedule repository.
     *
     * @return the schedule repository
     */
    ScheduleRepository scheduleRepository();

    /**
     * Schedule repository schedule repository.
     *
     * @param autoTx the auto tx
     * @return the schedule repository
     */
    ScheduleRepository scheduleRepository(TransactionalContext autoTx);

    /**
     * Exam repository exam repository.
     *
     * @return the exam repository
     */
    ExamRepository examRepository();

    /**
     * Exam repository exam repository.
     *
     * @param autoTx the auto tx
     * @return the exam repository
     */
    ExamRepository examRepository(TransactionalContext autoTx);

    PostItRepository postItRepository();

    PostItRepository postItRepository(TransactionalContext autoTx);

    /**
     * Shared board repository shared board repository.
     *
     * @param tx the tx
     * @return the shared board repository
     */
    SharedBoardRepository sharedBoardRepository(TransactionalContext tx);

    /**
     * Shared board repository shared board repository.
     *
     * @return the shared board repository
     */
    SharedBoardRepository sharedBoardRepository();

    /**
     * Enrollment repository enrollment repository.
     *
     * @return the enrollment repository
     */
    EnrollmentRepository enrollmentRepository();

    /**
     * Enrollment repository enrollment repository.
     *
     * @param autoTx the auto tx
     * @return the enrollment repository
     */
    EnrollmentRepository enrollmentRepository(TransactionalContext autoTx);

    /**
     * Student repository student repository.
     *
     * @return the student repository
     */
    StudentRepository studentRepository();

    /**
     * Student repository student repository.
     *
     * @param autoTx the auto tx
     * @return the student repository
     */
    StudentRepository studentRepository(TransactionalContext autoTx);

    /**
     * Lectures repository lectures repository.
     *
     * @return the lectures repository
     */
    LecturesRepository lecturesRepository();

    /**
     * Lectures repository lectures repository.
     *
     * @param autoTx the auto tx
     * @return the lectures repository
     */
    LecturesRepository lecturesRepository(TransactionalContext autoTx);

    /**
     * Cell repository cell repository.
     *
     * @return the cell repository
     */
    CellRepository cellRepository();


    /**
     * Permissions repository.
     *
     * @param autoTx the auto tx
     * @return the Permissions repository
     */
    PermissionRepository permissionRepository(TransactionalContext autoTx);

    /**
     * Permission repository permission repository.
     *
     * @return the permission repository
     */
    PermissionRepository permissionRepository();

    GradeRepository gradeRepository(TransactionalContext autoTx);

    GradeRepository gradeRepository();
}
