package eapli.base.app.teacher.console.presentation.exams;


import eapli.base.course.domain.Course;
import eapli.base.examformative.application.CreateFormativeExamController;
import eapli.base.question.domain.Question;
import eapli.base.question.domain.QuestionType;
import eapli.framework.general.domain.model.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.IOException;
import java.util.*;


/**
 * The type Create exam ui.
 */
public class CreateFormativeExamUI extends AbstractUI {

    private final CreateFormativeExamController controller = new CreateFormativeExamController();

    @Override
    protected boolean doShow() {
        StringBuilder formativeExam = new StringBuilder();
        Iterable<Course> coursesList = controller.listCourses();
        QuestionType selectedQuestionType = null;
        if (!coursesList.iterator().hasNext()) {
            System.out.println("Doesn't exist courses!");
            return false;
        }
        int i = 0;
        for (Course course : coursesList) {
            i++;
            System.out.println(i + " - " + course.toString());
        }

        boolean flag = true;
        Course selectedCourse = null;

        while (flag) {
            int indexCourse = Console.readInteger("Choose the Course index (0 to exit)");
            if (indexCourse == 0) {
                return false;
            } else {
                Iterator<Course> iterator = coursesList.iterator();
                for (int j = 0; j < indexCourse; j++) {
                    selectedCourse = iterator.next();
                }
                if (selectedCourse != null) {
                    flag = false;
                } else {
                    System.out.println("Choose a valid index!");
                }
            }
        }
        System.out.println("Welcome to the Create Formative Exam:");
        String examTitle = Console.readLine("Exam title: ");
        String examDescription = Console.readLine("Exam description: ");
        //Writing into the file
        String filePath = controller.createQuestionnaireTextFile(examTitle);
        String examHeader = ":: " + examTitle + ";\n\n:: " + examDescription + ";\n\n";
        formativeExam.append(examHeader);
        int  numberSections = Console.readInteger("Number of sections: ");
        Set<Question> selectedQuestions = new HashSet<>();
        for (int j = 0; j < numberSections; j++) {
            String sectionTitle = Console.readLine("Section Title:");
            Description sectionDescription = Description.valueOf(Console.readLine("Section description: "));
            //Writing into the file
            String sectionStruct = "//" + sectionTitle +";\n\n//" + sectionDescription + ";\n\n";
            formativeExam.append(sectionStruct);
            int numberOfQuestions = Console.readInteger("Number of questions: ");
            for (int k = 0; k < numberOfQuestions; k++) {
                System.out.println("Question " + (k + 1) + ":");
                System.out.println("Select question type: ");
                List<QuestionType> questionTypeList = Arrays.asList(QuestionType.values());
                SelectWidget<QuestionType> questionTypeSelector = new SelectWidget<>("Question Type:", questionTypeList);
                questionTypeSelector.show();
                selectedQuestionType = questionTypeSelector.selectedElement();

                Question selectedQuestion = controller.selectedQuestion(selectedQuestionType, selectedQuestions);
                formativeExam.append(selectedQuestion.question()).append("\n\n");

                selectedQuestions.add(selectedQuestion);
                }
            }
        controller.writeQuestionnaireTextFile(String.valueOf(formativeExam),filePath);
        try {
            controller.validateFormativeExam(filePath);
        } catch (IOException e) {
            System.out.println("Formative Exam Failed");
        }
        controller.saveFormativeExam(examTitle,String.valueOf(formativeExam),selectedCourse);

        return true;
    }

    @Override
    public String headline() {
        return "Create Exam in a Course";
    }
}




