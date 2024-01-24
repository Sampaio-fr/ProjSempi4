package eapli.base.meeting.domain;

import eapli.base.participant.domain.Participant;
import eapli.base.schedule.domain.Schedule;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The type Meeting.
 *
 */
@Entity
public class Meeting extends Schedule implements AggregateRoot<Long> {

    @Column(name = "TitleDefinition")
    private Designation meetingTitle;

    @Column(name = "State")
    @Enumerated(EnumType.STRING)
    private MeetingState meetingState;

    @OneToOne
    private ECourseUser eCourseUser;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private  List<Participant> participants;


    /**
     * Instantiates a new Meeting.
     */
    protected Meeting() {
    }

    /**
     * Instantiates a new Meeting.
     *
     * @param meetingTitle the class title
     * @param meetingState  the class type
     */
    public Meeting(Designation meetingTitle, MeetingState meetingState, Calendar initial,int duration, List<Participant> eCourseUsers,ECourseUser owner) {
        super(initial,duration);
        Preconditions.noneNull(meetingTitle, meetingState);
        this.meetingTitle = meetingTitle;
        this.meetingState = MeetingState.SCHEDULED;
       this.participants= eCourseUsers;
       this.eCourseUser = owner;
    }

    public ECourseUser ownerMeeting() {
        return eCourseUser;
    }

    public void defineOwnerMeeting(ECourseUser eCourseUser) {
        this.eCourseUser = eCourseUser;
    }
    public Meeting(Designation meetingTitle, MeetingState meetingState, Calendar initial,int duration) {
        super(initial,duration);
        Preconditions.noneNull(meetingTitle, meetingState);
        this.meetingTitle = meetingTitle;
        this.meetingState = MeetingState.SCHEDULED;
        this.participants= new ArrayList<>();
    }


    public List<Participant> eCourseUsers() {
        return this.participants;
    }

    public void replaceCourseUsers(List<Participant> participants) {
        this.participants = participants;
    }
    public void addCourseUsers(Participant participant) {
        this.participants.add(participant);
    }

    /**
     * Type meeting state.
     *
     * @return the meeting state
     */
    public MeetingState meetingType() {
        return meetingState;
    }

    /**
     * Is occurring boolean.
     *
     * @return the boolean
     */
    public boolean isOccurring() {
        return meetingType() == MeetingState.OCCURRING;
    }
    public boolean isCancelled() {
        return meetingType() == MeetingState.CANCELLED;
    }

    public void replaceMeetingState(MeetingState meetingState) {
        this.meetingState = meetingState;
    }

    /**
     * Is finished boolean.
     *
     * @return the boolean
     */
    public boolean isFinished() {
        return meetingType() == MeetingState.FINISHED;
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    public Designation meetingTitle() {
        return meetingTitle;
    }

    public void changeMeetingTitle(Designation meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public MeetingState meetingState() {
        return meetingState;
    }
    public void occuring(){
        this.meetingState = MeetingState.OCCURRING;
    }
    public void finish(){
        this.meetingState=MeetingState.FINISHED;
    }



    @Override
    public String toString() {
        return "Meeting{" +
                ", ClassTitle=" + meetingTitle +
                ", classType=" + meetingState +
                '}';
    }
}
