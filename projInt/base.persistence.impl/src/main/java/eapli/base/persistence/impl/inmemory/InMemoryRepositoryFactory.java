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
package eapli.base.persistence.impl.inmemory;

import eapli.base.CellLog.repositories.CellLogRepository;
import eapli.base.PostItLog.repositories.PostItLogRepository;
import eapli.base.SharedBoardLog.repositories.SharedBoardLogRepository;
import eapli.base.cell.repositories.CellRepository;
import eapli.base.enrollmentapproval.repositories.EnrollmentApprovalRepository;
import eapli.base.examformative.repositories.ExamFormativeRepository;
import eapli.base.lecture.repositories.LecturesRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.enrollment.repositories.EnrollmentRepository;
import eapli.base.exam.repositories.ExamRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.meeting.repositories.MeetingRepository;
import eapli.base.notificationMeeting.repositories.NotificationRepository;
import eapli.base.participant.repositories.ParticipantRepository;
import eapli.base.permission.repositories.PermissionRepository;
import eapli.base.persistence.impl.jpa.JPATimetableRepository;
import eapli.base.postIt.repositories.PostItRepository;
import eapli.base.question.repositories.QuestionRepository;
import eapli.base.schedule.repositories.ScheduleRepository;
import eapli.base.student.repositories.GradeRepository;
import eapli.base.teacherInCharge.repositories.TeacherInChargeRepository;
import eapli.base.user.repositories.ECourseUserRepository;
import eapli.base.sharedBoard.repositories.SharedBoardRepository;
import eapli.base.student.repositories.StudentRepository;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

/**
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public eapli.framework.infrastructure.authz.domain.repositories.UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public eapli.framework.infrastructure.authz.domain.repositories.UserRepository users() {
        return users(null);
    }

    @Override
    public JPATimetableRepository timetableRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public JPATimetableRepository timetableRepository() {
        return null;
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public QuestionRepository questionRepository() {
        return null;
    }

    @Override
    public QuestionRepository questionRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CourseRepository courseRepository(final TransactionalContext tx) {
        return new InMemoryCourseRepository();
    }

    @Override
    public MeetingRepository meetingRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public MeetingRepository meetingRepository() {
        return null;
    }

    @Override
    public TeacherRepository teacherRepository() {
        return null;
    }

    @Override
    public TeacherRepository teacherRepository(TransactionalContext autoTx) {
        return null;
    }
    @Override
    public TeacherInChargeRepository teacherInChargeRepository() {
        return null;
    }

    @Override
    public TeacherInChargeRepository teacherInChargeRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public ScheduleRepository scheduleRepository() {
        return null;
    }

    @Override
    public ScheduleRepository scheduleRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CourseRepository courseRepository() {
        return courseRepository(null);
    }


    @Override
    public ExamRepository examRepository() {
        return null;
    }

    @Override
    public ExamRepository examRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public PostItRepository postItRepository() {
        return null;
    }

    @Override
    public PostItRepository postItRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public SharedBoardRepository sharedBoardRepository(final TransactionalContext tx) {
        return new InMemorySharedBoardRepository();
    }

    @Override
    public SharedBoardRepository sharedBoardRepository() {
        return sharedBoardRepository();
    }

    @Override
    public EnrollmentRepository enrollmentRepository() {
        return null;
    }

    @Override
    public EnrollmentRepository enrollmentRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public StudentRepository studentRepository() {
        return null;
    }

    @Override
    public LecturesRepository lecturesRepository() {
        return null;
    }

    @Override
    public LecturesRepository lecturesRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CellRepository cellRepository() {
        return null;
    }

    @Override
    public PermissionRepository permissionRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public PermissionRepository permissionRepository() {
        return null;
    }

    @Override
    public GradeRepository gradeRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public GradeRepository gradeRepository() {
        return null;
    }

    @Override
    public StudentRepository studentRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public ExamFormativeRepository examFormativeRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public ExamFormativeRepository examFormativeRepository() {
        return null;
    }

    @Override
    public ECourseUserRepository eCourseUserRepository() {
        return null;
    }

    @Override
    public ECourseUserRepository eCourseUserRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public NotificationRepository notificationRepository() {
        return null;
    }

    @Override
    public NotificationRepository notificationRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public ParticipantRepository participantRepository() {
        return null;
    }

    @Override
    public ParticipantRepository participantRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CellRepository cellRepository(TransactionalContext tx) {
        return null;
    }

    @Override
    public EnrollmentApprovalRepository enrollmentApprovalRepository() {
        return null;
    }

    @Override
    public EnrollmentApprovalRepository enrollmentApprovalRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public SharedBoardLogRepository sharedBoardLogRepository() {
        return null;
    }

    @Override
    public SharedBoardLogRepository sharedBoardLogRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public PostItLogRepository postItLogRepository() {
        return null;
    }

    @Override
    public PostItLogRepository postItLogRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CellLogRepository cellLogRepository() {
        return null;
    }

    @Override
    public CellLogRepository cellLogRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}
