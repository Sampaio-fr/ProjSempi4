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
package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.CellLog.repositories.CellLogRepository;
import eapli.base.PostItLog.repositories.PostItLogRepository;
import eapli.base.SharedBoardLog.repositories.SharedBoardLogRepository;
import eapli.base.cell.repositories.CellRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.enrollment.repositories.EnrollmentRepository;
import eapli.base.enrollmentapproval.repositories.EnrollmentApprovalRepository;
import eapli.base.exam.repositories.ExamRepository;
import eapli.base.examformative.repositories.ExamFormativeRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.lecture.repositories.LecturesRepository;
import eapli.base.meeting.repositories.MeetingRepository;
import eapli.base.notificationMeeting.repositories.NotificationRepository;
import eapli.base.participant.repositories.ParticipantRepository;
import eapli.base.permission.repositories.PermissionRepository;
import eapli.base.postIt.repositories.PostItRepository;
import eapli.base.schedule.repositories.ScheduleRepository;
import eapli.base.sharedBoard.repositories.SharedBoardRepository;
import eapli.base.student.repositories.GradeRepository;
import eapli.base.student.repositories.StudentRepository;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.base.teacherInCharge.repositories.TeacherInChargeRepository;
import eapli.base.user.repositories.ECourseUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public eapli.framework.infrastructure.authz.domain.repositories.UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public eapli.framework.infrastructure.authz.domain.repositories.UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(), Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JPAQuestionRepository questionRepository(final TransactionalContext autoTx) {
        return new JPAQuestionRepository(autoTx);
    }

    @Override
    public JPAQuestionRepository questionRepository() {
        return new JPAQuestionRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public JPATimetableRepository timetableRepository(final TransactionalContext autoTx) {
        return new JPATimetableRepository(autoTx);
    }

    @Override
    public JPATimetableRepository timetableRepository() {
        return new JPATimetableRepository(Application.settings().getPersistenceUnitName());
    }


    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CourseRepository courseRepository(final TransactionalContext autoTx) {
        return new JpaCourseRepository(autoTx);
    }

    @Override
    public CourseRepository courseRepository() {
        return new JpaCourseRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public MeetingRepository meetingRepository(final TransactionalContext autoTx) {
        return new JPAMeetingRepository(autoTx);
    }

    @Override
    public MeetingRepository meetingRepository() {
        return new JPAMeetingRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TeacherRepository teacherRepository() {
        return new JPATeacherRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TeacherRepository teacherRepository(final TransactionalContext autoTx) {
        return new JPATeacherRepository(autoTx);
    }

    @Override
    public TeacherInChargeRepository teacherInChargeRepository() {
        return new JPATeacherInChargeRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TeacherInChargeRepository teacherInChargeRepository(final TransactionalContext autoTx) {
        return new JPATeacherInChargeRepository(autoTx);
    }

    @Override
    public ScheduleRepository scheduleRepository() {
        return new JPAScheduleRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ScheduleRepository scheduleRepository(final TransactionalContext autoTx) {
        return new JPAScheduleRepository(autoTx);
    }

    @Override
    public StudentRepository studentRepository() {
        return new JPAStudentRepository(Application.settings().getPersistenceUnitName());
    }


    @Override
    public StudentRepository studentRepository(final TransactionalContext autoTx) {
        return new JPAStudentRepository(autoTx);
    }


    @Override
    public EnrollmentRepository enrollmentRepository() {
        return new JPAEnrollmentRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public EnrollmentRepository enrollmentRepository(final TransactionalContext autoTx) {
        return new JPAEnrollmentRepository(autoTx);
    }

    @Override
    public PostItRepository postItRepository() {
        return new JpaPostItRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public PostItRepository postItRepository(final TransactionalContext autoTx) {
        return new JpaPostItRepository(autoTx);
    }

    @Override
    public SharedBoardRepository sharedBoardRepository(TransactionalContext tx) {
        return new JpaSharedBoardRepository(tx);
    }

    @Override
    public SharedBoardRepository sharedBoardRepository() {
        return new JpaSharedBoardRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ExamRepository examRepository(TransactionalContext autoTx) {
        return new JPAExamRepository(autoTx);
    }


    @Override
    public ExamRepository examRepository() {
        return new JPAExamRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ExamFormativeRepository examFormativeRepository(TransactionalContext autoTx) {
        return new JPAExamFormativeRepository(autoTx);
    }


    @Override
    public ExamFormativeRepository examFormativeRepository() {
        return new JPAExamFormativeRepository(Application.settings().getPersistenceUnitName());
    }


    public ECourseUserRepository eCourseUserRepository() {
        return new JPAECourseUserRepository(Application.settings().getPersistenceUnitName());
    }

    public ECourseUserRepository eCourseUserRepository(TransactionalContext autoTx) {
        return new JPAECourseUserRepository(autoTx);
    }

    @Override
    public LecturesRepository lecturesRepository() {
        return new JpaLecturesRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public LecturesRepository lecturesRepository(TransactionalContext autoTx) {
        return new JpaLecturesRepository(autoTx);
    }

    @Override
    public CellRepository cellRepository() {
        return new JPACellRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public PermissionRepository permissionRepository(TransactionalContext autoTx) {
        return new JpaPermissionRepository(autoTx);
    }

    @Override
    public PermissionRepository permissionRepository() {
        return new JpaPermissionRepository(Application.settings().getPersistenceUnitName());
    }


    @Override
    public NotificationRepository notificationRepository() {
        return new JPANotificationRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public NotificationRepository notificationRepository(TransactionalContext autoTx) {
        return new JPANotificationRepository(autoTx);
    }

    @Override
    public ParticipantRepository participantRepository() {
        return new JPAParticipantRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ParticipantRepository participantRepository(TransactionalContext autoTx) {
        return new JPAParticipantRepository(autoTx);
    }

    @Override
    public CellRepository cellRepository(TransactionalContext tx) {
        return new JPACellRepository(tx);
    }

    @Override
    public EnrollmentApprovalRepository enrollmentApprovalRepository() {
        return new JPAEnrollmentApprovalRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public EnrollmentApprovalRepository enrollmentApprovalRepository(TransactionalContext autoTx) {
        return new JPAEnrollmentApprovalRepository(autoTx);
    }


    @Override
    public SharedBoardLogRepository sharedBoardLogRepository() {
        return new JPASharedBoardLogRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SharedBoardLogRepository sharedBoardLogRepository(TransactionalContext autoTx) {
        return new JPASharedBoardLogRepository(autoTx);
    }

    @Override
    public CellLogRepository cellLogRepository() {
        return new JPACellLogRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CellLogRepository cellLogRepository(TransactionalContext autoTx) {
        return new JPACellLogRepository(autoTx);
    }

    @Override
    public PostItLogRepository postItLogRepository() {
        return new JPAPostItLogRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public PostItLogRepository postItLogRepository(TransactionalContext autoTx) {
        return new JPAPostItLogRepository(autoTx);
    }

    @Override
    public GradeRepository gradeRepository(TransactionalContext autoTx) {
        return new JPAGradeRepository(autoTx);
    }

    @Override
    public GradeRepository gradeRepository() {
        return new JPAGradeRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }


}
