package eapli.base.participant.repositories;


import eapli.base.meeting.domain.Meeting;
import eapli.base.participant.domain.Participant;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface ParticipantRepository extends DomainRepository<Long, Participant> {
    List<Participant> meetingParticipants (Meeting meeting);

}
