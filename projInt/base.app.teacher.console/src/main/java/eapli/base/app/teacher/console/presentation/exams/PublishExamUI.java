package eapli.base.app.teacher.console.presentation.exams;

import eapli.base.app.common.console.utils.DateTimeUtil;
import eapli.base.app.teacher.console.presentation.printer.ExamPrinter;
import eapli.base.app.teacher.console.presentation.printer.PrinterCourse;
import eapli.base.course.domain.Course;
import eapli.base.exam.application.PublishExamController;
import eapli.base.exam.domain.Exam;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.Calendar;
import java.util.Date;

public class PublishExamUI extends AbstractUI {

    private final PublishExamController controller = new PublishExamController();

    @Override
    protected boolean doShow() {

        Iterable<Course> myCourses = controller.myCourses();

        if (myCourses == null) {
            System.out.println("There are no available courses");
        } else {
            final SelectWidget<Course> selector = new SelectWidget<>("Your Courses:", myCourses, new PrinterCourse());
            selector.show();
            Course selectedCourse = selector.selectedElement();

            if (selectedCourse != null) {
                Iterable<Exam> examsList = selectedCourse.findExamList();

                if (examsList == null){
                    System.out.println("There are no available exams");
                }
                else {
                    final SelectWidget<Exam> examSelector = new SelectWidget<>("Exams List:", examsList, new ExamPrinter());
                    examSelector.show();
                    Exam selectedExam = examSelector.selectedElement();

                    if (selectedExam != null){
                        String rawDate;
                        Date dateTime;
                        do {
                            rawDate = Console.readLine("Write the new initial Exam date with time (dd/MM/YYYY HH:mm)");
                            dateTime = DateTimeUtil.toDateTime(rawDate);

                        } while (dateTime == null);

                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(dateTime);

                        final int rawDuration = Console.readInteger("Write the new duration");

                        controller.publishExam(selectedCourse, selectedExam, calendar, rawDuration);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Publish Exam";
    }
}
