package eapli.base.app.teacher.console.presentation.lectures;

import eapli.base.app.common.console.utils.DateTimeUtil;
import eapli.base.app.common.console.utils.DateUtil;
import eapli.base.lecture.application.ChangeLectureScheduleController;
import eapli.base.lecture.domain.Lecture;
import eapli.base.schedule.domain.Schedule;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Change lecture schedule ui.
 */
public class ChangeLectureScheduleUI extends AbstractUI {

    private final ChangeLectureScheduleController controller = new ChangeLectureScheduleController();

    @Override
    protected boolean doShow() {

        final Iterable<Lecture> myLectures = controller.myLectures();
        if (!myLectures.iterator().hasNext()) System.out.println("No registered lectures!");
        else {
            final SelectWidget<Lecture> selector = new SelectWidget<>("Lectures:", myLectures, new LecturePrinter());
            selector.show();
            final Lecture selectedLecture = selector.selectedElement();
            try {
                if(selectedLecture != null){
                    String rawDate;
                    Date dateTime;
                    do {
                        rawDate = Console.readLine("Write the new lecture date with time (dd/MM/YYYY HH:mm)");
                        dateTime = DateTimeUtil.toDateTime(rawDate);

                    } while (dateTime == null);

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dateTime);

                    final int rawDuration = Console.readInteger("Write the new duration");

                    this.controller.changeLectureSchedule(selectedLecture, calendar, rawDuration);
                }
            }catch (final Exception e){
                System.out.println(e.getMessage());
            }
        }
        return true;
    }

    public String headline() {
        return "Change Lecture Schedule";
    }
}
