package eapli.base.app.student.console.presentation.formativeexams;

import eapli.base.app.student.console.presentation.exams.DisplayExamImpl;
import eapli.base.examformative.application.DisplayFormativeExam;
import eapli.base.examformative.application.TakeFormativeExamController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("eapli.base.exam.application")
public class ExamFormativeConfig {

    @Bean
    public DisplayFormativeExam displayExam(){
        return new DisplayFormativeExamImpl();
    }

    @Bean
    public TakeFormativeExamController takeExamController(){
        return new TakeFormativeExamController();
    }
}
