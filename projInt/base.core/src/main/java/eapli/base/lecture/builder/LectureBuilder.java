package eapli.base.lecture.builder;

import eapli.base.course.domain.Course;
import eapli.base.lecture.domain.Lecture;
import eapli.base.lecture.domain.LectureType;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.domain.MeetingState;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Designation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.List;

/**
 * The type Meeting builder.
 */
public class LectureBuilder implements DomainFactory<Lecture> {

    private Lecture lecture;
    private LectureType type;
    private Designation lectureTitle;
    private Course course;
    private Calendar initial;
    private int duration;

    public LectureBuilder(){

    }

    public LectureBuilder withLectureTitle(final Designation lectureTitle){
        this.lectureTitle = lectureTitle;
        return this;
    }

    public LectureBuilder withCourse(final Course course){
        this.course=course;
        return this;
    }
    public LectureBuilder withLectureType(final LectureType type){
        this.type=type;
        return this;
    }
    public LectureBuilder withInitialDate(final Calendar initial){
        this.initial=initial;
        return this;
    }

    public LectureBuilder withDuration(final int duration){
        this.duration=duration;
        return this;
    }
    private Lecture buildOrThrow() {
        if (lecture != null) {
            return lecture;
        }
        if (lectureTitle != null && course !=null) {
            lecture = new Lecture(lectureTitle,type,initial,duration,course);
            return lecture;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public Lecture build(){
        final Lecture lec = buildOrThrow();
        lecture=null;
        return lec;
    }




}
