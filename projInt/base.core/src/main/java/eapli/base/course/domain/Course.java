package eapli.base.course.domain;


import eapli.base.exam.domain.Exam;
import eapli.base.examformative.domain.ExamFormative;
import eapli.base.student.domain.Student;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacherInCharge.domain.TeacherInCharge;
import eapli.base.timetable.domain.TimeTable;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;
import javax.persistence.*;
import javax.persistence.Id;

import java.util.*;


/**
 * The type Course.
 */
@Entity
@Table
public class Course implements AggregateRoot<Code>, CourseEvents {

    @Id
    @Column(name = "id")
    private Code id;
    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "CourseTitle"))
    private Designation courseTitle;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "CourseDescription"))
    private Description courseDescription;

    @Enumerated(EnumType.STRING)
    private CourseState courseState;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Exam> examList;

    @Column(name = "minimum")
    private int minimumCapacity;

    @Column(name = "maximum")
    private int maximumCapacity;

    @OneToOne
   // @JoinColumn(name = "teacher_in_charge_id", referencedColumnName = "acronym")
    private TeacherInCharge teacherInCharge;

    @ManyToMany
    @JoinTable(name = "course_teacher")
    private List<Teacher> teachers;

    @OneToMany
    @Column(name = "ListOfStudent")
    private List<Student> studentSet;

    @OneToOne
    private TimeTable timeTable;


    /**
     * Instantiates a new Course.
     */
    protected Course() {
    }

    /**
     * Instantiates a new Course.
     *
     * @param courseTitle       the course title
     * @param courseDescription the course description
     * @param charge            the charge
     * @param code           the edition
     * @param minimumCapacity   the minimum capacity
     * @param maximumCapacity   the maximum capacity
     */
    public Course(Designation courseTitle, Description courseDescription, TeacherInCharge charge, Code code, int minimumCapacity, int maximumCapacity, TimeTable timeTable) {

        Preconditions.noneNull(courseTitle, courseDescription, code, maximumCapacity, minimumCapacity);

        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.courseState = CourseState.CLOSE;
        this.id = code;
        this.teacherInCharge = charge;
        this.teachers = new ArrayList<>();
        this.maximumCapacity = maximumCapacity;
        this.minimumCapacity = minimumCapacity;
        this.studentSet = new ArrayList<>();
        this.timeTable = timeTable;
        this.examList = new ArrayList<>();
    }


    public TimeTable timeTable() {
        return timeTable;
    }

    public void replaceTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }

    /**
     * Find exam list list.
     *
     * @return the list
     */
    public List<Exam> findExamList() {
        return examList;
    }

    /**
     * Add total exam list.
     *
     * @param examList the exam list
     */
    public void addTotalExamList(List<Exam> examList) {
        this.examList = examList;
    }

    /**
     * Add exam.
     *
     * @param exam the exam
     */
    public void addExam(Exam exam) {
        this.examList.add(exam);
    }


    /**
     * Gets course title.
     *
     * @return the course title
     */
    public Designation courseTitle() {
        return courseTitle;
    }

    /**
     * Gets course description.
     *
     * @return the course description
     */
    public Description courseDescription() {
        return courseDescription;
    }

    /**
     * Gets course state.
     *
     * @return the course state
     */
    public CourseState courseState() {
        return courseState;
    }



    /**
     * Sets teacher in charge.
     *
     * @param teacherInCharge the teacher in charge
     */
    public void changeTeacherInCharge(TeacherInCharge teacherInCharge) {
        this.teacherInCharge = teacherInCharge;
    }

    /**
     * Gets minimum capacity.
     *
     * @return the minimum capacity
     */
    public int minimumCapacity() {
        return minimumCapacity;
    }

    /**
     * Sets minimum capacity.
     *
     * @param minimumCapacity the minimum capacity
     */
    public void changeMinimumCapacity(int minimumCapacity) {
        this.minimumCapacity = minimumCapacity;
    }

    /**
     * Gets maximum capacity.
     *
     * @return the maximum capacity
     */
    public int maximumCapacity() {
        return maximumCapacity;
    }

    /**
     * Sets maximum capacity.
     *
     * @param maximumCapacity the maximum capacity
     */
    public void changeMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }
    public void addTeacher(Teacher t){this.teachers.add(t);}
    public TeacherInCharge teacherInCharge(){return this.teacherInCharge;}
    public List<Teacher> teachers(){return this.teachers;}

    /**
     * Gets student set.
     *
     * @return the student set
     */
    public List<Student> studentSet() {
        return studentSet;
    }

    /**
     * Sets student set.
     *
     * @param studentSet the student set
     */
    public void changeStudentSet(List<Student> studentSet) {
        this.studentSet = studentSet;
    }

    /**
     * Add student boolean.
     *
     * @param student the student
     * @return the boolean
     */
    public boolean addStudent(Student student) {
        return studentSet.add(student);
    }

    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof Course)) {
            return false;
        }

        final Course that = (Course) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity()) && courseTitle.equals(that.courseTitle) && courseDescription.equals(that.courseDescription) && courseState == that.courseState && id.equals(that.id);
    }

    @Override
    public Code identity() {
        return this.id;
    }


    @Override
    public void openCourse() {
        if(this.courseState == CourseState.CLOSE){
            this.courseState=CourseState.OPEN;
        }else{
            System.out.println("The course actual state is: "+ this.courseState+" and so it is impossible to change it to open!");
        }
    }

    @Override
    public void openEnrollment() {
        this.courseState = CourseState.ENROLL;
    }

    @Override
    public void closeEnrollment() {
        this.courseState = CourseState.INPROGRESS;
    }

    @Override
    public void closeCourse() {
        if(this.courseState == CourseState.INPROGRESS){
            this.courseState=CourseState.CLOSED;
        }else if(this.courseState == CourseState.OPEN && (studentSet.size()>maximumCapacity || studentSet.size()<minimumCapacity)){
            this.courseState=CourseState.CLOSED;
        }else{
            System.out.println("The course actual state is: "+ this.courseState+" and so it is impossible to change it to open!");
        }
    }


    @Override
    public String toString() {
        return "Course:" + "\n" +
                "Course Title=" + courseTitle + "\n" +
                "Course Description=" + courseDescription + "\n" +
                "Course State=" + courseState + "\n" +
                "Edition=" + id +"\n" ;
    }
}
