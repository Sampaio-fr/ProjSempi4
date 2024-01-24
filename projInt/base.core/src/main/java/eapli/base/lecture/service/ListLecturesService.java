package eapli.base.lecture.service;

import eapli.base.lecture.domain.Lecture;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.schedule.domain.Schedule;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.base.timetable.repositories.TimetableRepository;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

/**
 * The type List lectures service.
 */
@ApplicationService
public class ListLecturesService {

    private final AuthorizationService auth = AuthzRegistry.authorizationService();
    private final TeacherRepository teacherRepository = PersistenceContext.repositories().teacherRepository();
    private final TimetableRepository timetableRepository = PersistenceContext.repositories().timetableRepository();

    /**
     * My lectures iterable.
     *
     * @return the iterable
     */
    public Iterable<Teacher> myDetails(){
        SystemUser systemUser = auth.session().get().authenticatedUser();

        return teacherRepository.myDetails(systemUser);
    }

    public Iterable<Lecture> myLectures(ECourseUser user){
        List<Lecture> lecturesList = new ArrayList<>();

        for (Schedule schedule : user.timeTable().listSchedules()){
            if (schedule instanceof Lecture){
                lecturesList.add((Lecture) schedule);
            }
        }

        return lecturesList;
    }
}
