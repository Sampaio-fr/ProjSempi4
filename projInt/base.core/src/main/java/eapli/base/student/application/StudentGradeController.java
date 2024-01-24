package eapli.base.student.application;

import eapli.base.course.services.ListUserCourseService;
import eapli.base.student.domain.Grade;
import eapli.base.student.service.GradeManagementService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public class StudentGradeController {
    private final GradeManagementService gradesService = new GradeManagementService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public List<Grade> listStudentGrades(){
        SystemUser systemUser = authz.session().get().authenticatedUser();
        return gradesService.listStudentGrades(systemUser.email());
    }


}
