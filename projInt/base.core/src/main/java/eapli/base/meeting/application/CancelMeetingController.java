package eapli.base.meeting.application;

import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.service.MeetingManagementService;

import java.util.ArrayList;

/**
 * The type Cancel meeting controller.
 */
public class CancelMeetingController {

    private MeetingManagementService meetingManagementService ;

    /**
     * Instantiates a new Cancel meeting controller.
     */
    public CancelMeetingController() {
        this.meetingManagementService = new MeetingManagementService();
    }


    /**
     * Delete meeting.
     *
     * @param current the current
     */
    public void deleteMeeting(Meeting current) {
        meetingManagementService.deleteMeeting(current);
    }

    /**
     * List of meetings owner array list.
     *
     * @return the array list
     */
    public Iterable<Meeting> listOfMeetingsOwner() {
        return meetingManagementService.listOfMeetingsOwner();
    }
}
