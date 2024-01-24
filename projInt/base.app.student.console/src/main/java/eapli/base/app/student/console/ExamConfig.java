package eapli.base.app.student.console;

import eapli.base.exam.application.DisplayExam;
import eapli.base.app.student.console.presentation.exams.DisplayExamImpl;
import eapli.base.exam.application.TakeExamController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("eapli.base.exam.application")
public class ExamConfig {

    @Bean
    public DisplayExam displayExam(){
        return new DisplayExamImpl();
    }

    @Bean
    public TakeExamController takeExamController(){
        return new TakeExamController();
    }
}
