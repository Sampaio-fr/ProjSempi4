package eapli.base.meeting.application;

import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.service.MeetingManagementService;
import eapli.base.participant.domain.Participant;
import eapli.base.user.domain.ECourseUser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The type Create meeting controller.
 */
public class CreateMeetingController {

    private MeetingManagementService meetingManagementService ;


    /**
     * Instantiates a new Create meeting controller.
     */
    public CreateMeetingController() {
        this.meetingManagementService = new MeetingManagementService();
    }


    /**
     * Search usersavailable list.
     *
     * @param schedule the schedule
     * @return the list
     */
    public ArrayList<ECourseUser> searchUsersavailable(Meeting schedule) {
        return meetingManagementService.searchUsersavailable(schedule);
    }


    /**
     * Create meeting meeting.
     *
     * @param meetingTitle the meeting title
     * @param initialDate  the initial date
     * @param duration     the duration
     * @param es           the es
     * @return the meeting
     */
    public Meeting createMeeting(String meetingTitle, Calendar initialDate, int duration, ArrayList<Participant> es) {
    return this.meetingManagementService.createMeeting(meetingTitle,initialDate,duration,es);

    }


    /**
     * Add users.
     *
     * @param list    the list
     * @param meeting the meeting
     */
    public void addUsers(ArrayList<ECourseUser> list, Meeting meeting) {
        meetingManagementService.addUsers(list, meeting);
    }
}
