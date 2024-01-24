package eapli.base.meeting.builder;

import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.domain.MeetingState;
import eapli.base.participant.domain.Participant;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.general.domain.model.Designation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.List;

/**
 * The type Meeting builder.
 */
public class MeetingBuilder {

    private static final Logger LOGGER = LogManager.getLogger(MeetingBuilder.class);

    private Designation meetingTitle;
    private MeetingState meetingState;
    private Calendar initial;
    private int duration;
    private List<Participant> eCourseUsers;
    private ECourseUser user;


    /**
     * Withmeeting title meeting builder.
     *
     * @param meetingTitle the meeting title
     * @return the meeting builder
     */
    public MeetingBuilder withmeetingTitle(Designation meetingTitle) {
        this.meetingTitle = meetingTitle;
        return this;
    }

    public MeetingBuilder withUserOwner(ECourseUser eCourseUser) {
        this.user = eCourseUser;
        return this;
    }

    /**
     * With meeting state meeting builder.
     *
     * @param meetingState the meeting state
     * @return the meeting builder
     */
    public MeetingBuilder withMeetingState(MeetingState meetingState) {
        this.meetingState = meetingState;
        return this;
    }

    /**
     * With calendar initial meeting builder.
     *
     * @param initial the initial
     * @return the meeting builder
     */
    public MeetingBuilder withCalendarInitial(Calendar initial) {
        this.initial = initial;
        return this;
    }

    /**
     * With duration meeting builder.
     *
     * @param duration the duration
     * @return the meeting builder
     */
    public MeetingBuilder withDuration(int duration) {
        this.duration = duration;
        return this;
    }


    /**
     * With list users meeting builder.
     *
     * @param eCourseUsers the e course users
     * @return the meeting builder
     */
    public MeetingBuilder withListUsers(List<Participant> eCourseUsers) {
        this.eCourseUsers = eCourseUsers;
        return this;
    }


    /**
     * Instantiates a new Meeting builder.
     */
    public MeetingBuilder() {
    }

    /**
     * Build meeting.
     *
     * @return the meeting
     */
    public Meeting build() {
        Meeting meeting = new Meeting(this.meetingTitle,this.meetingState,this.initial,this.duration,this.eCourseUsers,this.user);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating new Meeting {}  with system info ", this.meetingTitle);
        }

        return meeting;
    }

}
