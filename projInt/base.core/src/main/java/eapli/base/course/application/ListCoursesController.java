package eapli.base.course.application;

import eapli.base.course.domain.Course;

import java.util.ArrayList;

import eapli.base.course.services.ListUserCourseService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;


import java.util.List;

/**
 * The List courses controller.
 */
public class ListCoursesController {

    private final ListUserCourseService userCourseService = new ListUserCourseService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    /**
     * List courses by user list.
     *
     * @return the list
     */
    public Iterable<Course> listCoursesByUser() {
        SystemUser systemUser = authz.session().get().authenticatedUser();

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.ADMIN)){
            return userCourseService.listCourses();
        } else if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.TEACHER)) {
            return userCourseService.listCoursesByTeacher(systemUser.email());
        }

        return null;
    }

    public Iterable<Course> listCoursesEnrolled() {
        SystemUser systemUser = authz.session().get().authenticatedUser();
        return userCourseService.listCourseByStudent(systemUser.email());
    }
    public Iterable<Course> listCoursesAvailable(){

        SystemUser systemUser = authz.session().get().authenticatedUser();

        List<Course> fullList = new ArrayList<>();
        Iterable<Course> availableCourses = userCourseService.listCourseAvailableByStudent();
        Iterable<Course> enrolledCourses = userCourseService.listCourseByStudent(systemUser.email());

        for (Course c: availableCourses){
            fullList.add(c);
        }
        for (Course c: enrolledCourses){
            if (fullList.contains(c)){
                fullList.remove(c);
            }
        }
        Iterable<Course> availableStudentCourses = fullList;
        return availableStudentCourses;


    }


}
