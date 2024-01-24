package eapli.base.infrastructure.bootstrapers.demo;


import eapli.base.course.application.CreateCourseController;
import eapli.base.course.domain.Code;
import eapli.framework.actions.Action;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

public class CourseBootstrapper implements Action {
    private CreateCourseController createCourseController;
    @Override
    public boolean execute() {
        createCourseController = new CreateCourseController();


        createCourseController.createCourses(Designation.valueOf("Java"),
                Description.valueOf("Java  "),new Code("JAVA-LEI-SEM1"),
                22,55);

        createCourseController.createCourses(Designation.valueOf("Java2"),
                Description.valueOf("Java Orientado Objetos"),new Code("JAVA-LEI-SEM2"),
                12,15);


        createCourseController.createCourses(Designation.valueOf("ESOFT"),
                Description.valueOf("Engenharia de Software"),new Code("ESOFT-LEI-SEM1"),
                2,165);

        createCourseController.createCourses(Designation.valueOf("EAPLI"),
                Description.valueOf("Eapli Design"),new Code("EAPLI-LEI-SEM2"),
                50,120);



        return false;
    }
}
