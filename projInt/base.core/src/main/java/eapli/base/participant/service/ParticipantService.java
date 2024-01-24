package eapli.base.participant.service;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.repositories.MeetingRepository;
import eapli.base.notificationMeeting.builder.NotificationBuilder;
import eapli.base.notificationMeeting.domain.Notification;
import eapli.base.notificationMeeting.domain.NotificationState;
import eapli.base.notificationMeeting.repositories.NotificationRepository;
import eapli.base.participant.domain.Participant;
import eapli.base.participant.domain.ParticipantState;
import eapli.base.participant.repositories.ParticipantRepository;
import eapli.base.user.repositories.ECourseUserRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import javax.transaction.Transactional;

public class ParticipantService {

    private final AuthorizationService authorizationService;
    private ParticipantRepository participantRepository;

    public ParticipantService() {
        this.authorizationService = AuthzRegistry.authorizationService();
        this.participantRepository = PersistenceContext.repositories().participantRepository();
    }

    @Transactional
    public Participant createParticipant(Notification notification) {
        Participant participant = null;
        if (notification.notificationState() == NotificationState.ACCEPTED){
         participant = new Participant(notification.Meeting(),notification.eCourseUser(), ParticipantState.ACCEPTED);
        }else if (notification.notificationState() == NotificationState.DECLINED){
         participant = new Participant(notification.Meeting(),notification.eCourseUser(), ParticipantState.DECLINED);
        }
        return participantRepository.save(participant);
    }


}
