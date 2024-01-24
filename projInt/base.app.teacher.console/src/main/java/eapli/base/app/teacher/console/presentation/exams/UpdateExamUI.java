package eapli.base.app.teacher.console.presentation.exams;

import eapli.base.app.teacher.console.presentation.printer.ExamPrinter;
import eapli.base.app.teacher.console.presentation.printer.PrinterCourse;
import eapli.base.course.domain.Course;
import eapli.base.exam.application.UpdateExamController;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.domain.FeedbackType;
import eapli.base.exam.domain.GradeType;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;


public class UpdateExamUI extends AbstractUI {

    private final UpdateExamController updateExamController = new UpdateExamController();

    @Override
    protected boolean doShow() {
        Exam examUpdated;
        Exam selectedExam;

        System.out.println("Welcome to the Update Exam:");
        final Iterable<Course> openCourses = this.updateExamController.findCourses();
        if (!openCourses.iterator().hasNext()) System.out.println("No registered courses!");
        else {
            SelectWidget<Course> selector = new SelectWidget<>("Courses:", openCourses, new PrinterCourse());
            selector.show();
            Course selectedCourse = selector.selectedElement();
            try {
                final Iterable<Exam> listExams = updateExamController.findExams(selectedCourse);
                if (!listExams.iterator().hasNext()) System.out.println("No Exams registered");
                else {
                    SelectWidget<Exam> selectorE = new SelectWidget<>("Exams:", listExams, new ExamPrinter());
                    selectorE.show();
                    selectedExam = selectorE.selectedElement();
                    try {
                        if (selectedExam != null) {
                            if (selectedCourse != null) {
                                final SelectWidget<FeedbackType> fSelector = new SelectWidget<>("Feedback type:", Arrays.asList(FeedbackType.values()));
                                fSelector.show();
                                FeedbackType selectedFeedbackType = fSelector.selectedElement();
                                try {
                                    if (selectedFeedbackType != null) {
                                        final SelectWidget<GradeType> gSelector = new SelectWidget<>("Grade type:", Arrays.asList(GradeType.values()));
                                        gSelector.show();
                                        GradeType selectedGradeType = gSelector.selectedElement();
                                        try {
                                            if (selectedGradeType != null) {
                                                String path = Console.readLine("Enter the path to the Updated Exam:");

                                                try {
                                                    examUpdated = updateExamController.updateExam(selectedExam, path, selectedFeedbackType, selectedGradeType);
                                                    System.out.println("Exam updated:");
                                                    System.out.println("--------------------------------");
                                                    System.out.println(examUpdated.teacher().identity());
                                                    System.out.println(examUpdated.course().identity());
                                                    System.out.println(examUpdated.examState());
                                                    updateExamController.saveUpdatedExam(selectedCourse, examUpdated);
                                                } catch (IOException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                            }

                                        } catch (final Exception e) {
                                            System.out.println("No grade types available");
                                        }
                                    }
                                } catch (final Exception e) {
                                    System.out.println("No feedback types available");
                                }
                            }
                        }
                    } catch (final Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        return false;
    }

    @Override
    public String headline() {
        return "Update Exams";
    }

    // Helper method to parse a date string into a Calendar object
    private static Calendar parseDate(String dateStr) {
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateStr);
            calendar.setTime(date);
            if (calendar.after(calendar)) {
                throw new ParseException("Invalid date", 2);
            }
        } catch (ParseException e) {
            System.out.println("Error parsing date");
            return null;
        }
        return calendar;
    }
}
