package eapli.base.meeting.service;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.meeting.builder.MeetingBuilder;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.domain.MeetingState;
import eapli.base.meeting.repositories.MeetingRepository;
import eapli.base.notificationMeeting.domain.Notification;
import eapli.base.notificationMeeting.services.NotificationAcceptanceService;
import eapli.base.participant.domain.Participant;
import eapli.base.schedule.domain.Schedule;
import eapli.base.schedule.repositories.ScheduleRepository;
import eapli.base.student.repositories.StudentRepository;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.base.timetable.domain.TimeTable;
import eapli.base.timetable.repositories.TimetableRepository;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.repositories.ECourseUserRepository;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The type Meeting management service.
 */
public class MeetingManagementService {

    private final AuthorizationService authorizationService;
    private final MeetingRepository meetingRepository;
    private final ScheduleRepository scheduleRepository;
    private final MeetingBuilder meetingBuilder;
    private final ECourseUserRepository eCourseUserRepository;
    private final TimetableRepository timetableRepository;
    private final NotificationAcceptanceService notificationAcceptanceService;


    /**
     * Instantiates a new Meeting management service.
     */
    public MeetingManagementService() {
        this.authorizationService = AuthzRegistry.authorizationService();
        this.meetingRepository = PersistenceContext.repositories().meetingRepository();
        this.scheduleRepository =PersistenceContext.repositories().scheduleRepository();
        this.meetingBuilder = new MeetingBuilder();
        this.eCourseUserRepository = PersistenceContext.repositories().eCourseUserRepository();
        this.notificationAcceptanceService = new NotificationAcceptanceService();
        this.timetableRepository = PersistenceContext.repositories().timetableRepository();
    }


    /**
     * Save meeting.
     *
     * @param meeting the meeting
     * @return meeting
     */
    public Meeting saveMeeting(Meeting meeting) {

        Meeting meeting1 = this.meetingRepository.save(meeting);
        return this.scheduleRepository.save(meeting1);

    }

    private ECourseUser findOwnerMeeting() {
        EmailAddress email = authorizationService.session().get().authenticatedUser().email();
        return eCourseUserRepository.ofIdentity(email).get();
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
        ECourseUser owner = findOwnerMeeting();
        System.out.println(owner);
    Meeting meeting = meetingBuilder.withmeetingTitle(Designation.valueOf(meetingTitle)).withMeetingState(MeetingState.SCHEDULED)
            .withCalendarInitial(initialDate).withDuration(duration).withListUsers(es).withUserOwner(owner).build();
        ;
        return saveMeeting(meeting);
    }


    /**
     * Search usersavailable array list.
     *
     * @param meeting the meeting
     * @return the array list
     */
    public ArrayList<ECourseUser> searchUsersavailable(Meeting meeting) {
        ArrayList<ECourseUser> listUser = (ArrayList<ECourseUser>) eCourseUserRepository.findAll();
        return availableUsers(listUser,meeting);

    }



    private ArrayList<ECourseUser> availableUsers(List<ECourseUser> listUser, Meeting meeting) {
        ArrayList<ECourseUser> users = new ArrayList<>();
        boolean flag;
        for (ECourseUser user:listUser) {
            flag = true;
            for (Schedule schedule:user.timeTable().listSchedules()) {
                if (!doRangesNotOverlap(schedule.initialDate(), schedule.finalDate(), meeting.initialDate(), meeting.finalDate())) {
                    flag = false;
                }
            }
            if (flag) {
                users.add(user);
            }
        }
        return users;
    }


    /**
     * Do ranges not overlap boolean.
     *
     * @param initialDate1 the initial date 1
     * @param finalDate1   the final date 1
     * @param initialDate2 the initial date 2
     * @param finalDate2   the final date 2
     * @return the boolean
     */
    public  boolean doRangesNotOverlap(Calendar initialDate1, Calendar finalDate1,
                                             Calendar initialDate2, Calendar finalDate2) {
        // Check if finalDate1 is before initialDate2 or initialDate1 is after finalDate2
        // Also check if the dates are equal
        return finalDate1.compareTo(initialDate2) < 0 || initialDate1.compareTo(finalDate2) > 0
                || finalDate1.compareTo(initialDate2) == 0 || initialDate1.compareTo(finalDate2) == 0;
    }


    /**
     * Add users.
     *
     * @param list    the list
     * @param meeting the meeting
     */
    public void addUsers(ArrayList<ECourseUser> list, Meeting meeting) {
        Meeting meeting2 = saveMeeting(meeting);
        sendNotifications(list,meeting2);
    }

    private void sendNotifications(ArrayList<ECourseUser> list, Meeting meeting) {
        notificationAcceptanceService.createNotifications(meeting,list);
    }

    /**
     * List of meetings owner array list.
     *
     * @return the array list
     */
    public Iterable<Meeting> listOfMeetingsOwner() {
        ECourseUser owner = findOwnerMeeting();
        return meetingRepository.meetingOwnerList(owner);
    }

    /**
     * Delete meeting.
     *
     * @param current the current
     */
    public void deleteMeeting(Meeting current) {
     ArrayList<Notification> list= notificationAcceptanceService.findAllNotificationsForThisMeeting(current);
     notificationAcceptanceService.deleteNotifications(list);
     current.replaceMeetingState(MeetingState.CANCELLED);
     current = meetingRepository.save(current);
     List<Participant> ecourseList = current.eCourseUsers();
        for (Participant participant:ecourseList) {
            deleteSchedule(participant.eCourseUser().timeTable(),current);
        }

    }


    public void deleteSchedule(TimeTable current,Schedule schedule) {
        current.listSchedules().remove(schedule);
        timetableRepository.save(current);
    }
}
