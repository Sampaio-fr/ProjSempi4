package eapli.base.student.service;

import eapli.base.course.domain.Course;
import eapli.base.exam.domain.Exam;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.student.domain.Grade;
import eapli.base.student.domain.Student;
import eapli.base.student.repositories.GradeRepository;
import eapli.base.student.repositories.StudentRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public class GradeManagementService {

    private final GradeRepository gradeRepository = PersistenceContext.repositories().gradeRepository();
    private final StudentRepository studentRepository = PersistenceContext.repositories().studentRepository();

    public void saveNewGrade(Student student, Course course, Exam exam, int examGrade, float myGrade) {
        Grade grade = new Grade(course, exam, examGrade, myGrade);
        try {
            gradeRepository.save(grade);
            student.addGrade(grade);
            studentRepository.save(student);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Grade> listStudentGrades(EmailAddress email){
        Student std = studentRepository.findStudentByEmail(email);
        return std.getGradeList();

    }
}
