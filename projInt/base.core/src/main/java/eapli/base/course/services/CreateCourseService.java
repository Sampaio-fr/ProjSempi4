package eapli.base.course.services;


import eapli.base.course.builder.CourseBuilder;
import eapli.base.course.domain.*;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.timetable.domain.TimeTable;
import eapli.base.timetable.repositories.TimetableRepository;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


/**
 * The type Create course service.
 */
public class CreateCourseService {

    private final AuthorizationService authorizationService;
    private final CourseRepository courseRepository;
    private final TimetableRepository timetableRepository;
    private final CourseBuilder createCourseBuilder;
    private Course course;


    /**
     * Instantiates a new Create course service.
     */
    public CreateCourseService() {
        this.authorizationService = AuthzRegistry.authorizationService();
        this.courseRepository = PersistenceContext.repositories().courseRepository();
        this.timetableRepository = PersistenceContext.repositories().timetableRepository();
        this.createCourseBuilder = new CourseBuilder();
    }

    /**
     * Validate course boolean.
     *
     * @param ids the ids
     * @return the boolean
     */
    public boolean findCourseByIdBoolean(String ids) {
        Code id = new Code(ids);
        return courseRepository.containsOfIdentity(id);
    }

    /**
     * Create  course.
     *
     * @param courseTitle       the course title
     * @param courseDescription the course description
     * @param code           the edition
     * @param minimumCapacity   the minimum capacity
     * @param maximumCapacity   the maximum capacity
     * @return the course
     */
    public Course createCourse(Designation courseTitle, Description courseDescription, Code code, int minimumCapacity, int maximumCapacity) {
        TimeTable timeTable = new TimeTable();
       timeTable = timetableRepository.save(timeTable);
        course = createCourseBuilder.withCourseTitle(courseTitle).withCourseDescription(courseDescription).withEdition(code).withMinimumCapacity(minimumCapacity).withMaximumCapacity(maximumCapacity).withTimeTable(timeTable).build();
        return saveCourse(course);
    }

    /**
     * Save  course.
     *
     * @param course the course
     * @return the course
     */
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

}
