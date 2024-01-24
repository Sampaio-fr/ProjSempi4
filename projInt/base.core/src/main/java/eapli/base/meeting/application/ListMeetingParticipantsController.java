package eapli.base.meeting.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.service.MeetingManagementService;
import eapli.base.participant.domain.Participant;
import eapli.base.participant.repositories.ParticipantRepository;

import java.util.List;

public class ListMeetingParticipantsController {

    private MeetingManagementService meetingManagementService ;
    private ParticipantRepository participantRepository;
    public ListMeetingParticipantsController(){
        this.meetingManagementService = new MeetingManagementService();
        this.participantRepository = PersistenceContext.repositories().participantRepository();
    }

    public Iterable<Meeting> userMeetings(){
        return meetingManagementService.listOfMeetingsOwner();
    }

    public List<Participant>  meetingParticipants (Meeting selectedMeeting){
        return participantRepository.meetingParticipants(selectedMeeting);
    }

}
