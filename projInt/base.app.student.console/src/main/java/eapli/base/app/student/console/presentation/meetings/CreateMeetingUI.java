package eapli.base.app.student.console.presentation.meetings;


import eapli.base.meeting.application.CreateMeetingController;
import eapli.base.meeting.domain.Meeting;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The type Create meeting ui.
 */
public class CreateMeetingUI extends AbstractUI {

    private final CreateMeetingController createMeetingController = new CreateMeetingController();

    @Override
    protected boolean doShow() {
        boolean flag;
        do {
            System.out.println("Creation of the course");
            flag = true;

            // requests data
            final String meetingTitle = Console.readLine("Enter the title of the Meeting:");
            String initialDateStr =  Console.readLine("Enter the initial date of the Meeting(YYYY-MM-DD HH:MM):");
            Calendar initialDate = parseDate(initialDateStr);
            if (initialDate !=null){
                int duration = Console.readInteger("Enter the duration in minutes:");



                try {
                    Meeting meeting =createMeetingController.createMeeting(meetingTitle,initialDate,duration,new ArrayList<>());
                    System.out.println(meeting.meetingTitle() + ": " + meeting.meetingState() + ": " + meeting.initialDate());

                    ArrayList<ECourseUser> users = createMeetingController.searchUsersavailable(meeting);
                    ArrayList<ECourseUser> list = selectECourseUsers(users);
                    createMeetingController.addUsers(list,meeting);

                } catch (IllegalArgumentException e) {
                    flag = false;
                    System.out.println("Unsuccessful operation!");
                    System.out.println(e.getMessage());
                }
            }else {
                flag = false;
            }

        } while (!flag);
        return false;
    }

    // Helper method to parse a date string into a Calendar object
    private static Calendar parseDate(String dateStr) {
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateStr);
            calendar.setTime(date);
        } catch (ParseException e) {
            System.out.println("Error parsing date");
            return null;
        }
        return calendar;
    }

    @Override
    public String headline() {
        return "Create Meeting UI";
    }

    /**
     * Select e course users list.
     *
     * @param eCourseUsers the e course users
     * @return the list
     */
    public ArrayList<ECourseUser> selectECourseUsers(ArrayList<ECourseUser> eCourseUsers) {
        ArrayList<ECourseUser> selectedUsers = new ArrayList<>();

        // Display the available ECourseUser objects for selection
        System.out.println("Available ECourseUsers:");
        for (int i = 0; i < eCourseUsers.size(); i++) {
            ECourseUser user = eCourseUsers.get(i);
            System.out.println((i + 1) + ". " + user.shortName() + "->" + user.email());
        }

        // Prompt the user for their choices
        System.out.println("Select the ECourseUsers (separated by commas):");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        // Split the user input into individual choices
        String[] choices = userInput.split(",");

        // Add the selected ECourseUser objects to the list
        for (String choice : choices) {
            int index = Integer.parseInt(choice.trim()) - 1;
            if (index >= 0 && index < eCourseUsers.size()) {
                selectedUsers.add(eCourseUsers.get(index));
            }
        }

        // Return the selected ECourseUser objects
        return selectedUsers;
    }
}


