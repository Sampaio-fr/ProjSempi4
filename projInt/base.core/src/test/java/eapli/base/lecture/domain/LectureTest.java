package eapli.base.lecture.domain;

import eapli.base.schedule.domain.Schedule;
import eapli.base.teacher.domain.Teacher;
import eapli.base.lecture.domain.Lecture;
import eapli.base.lecture.domain.LectureType;
import eapli.framework.general.domain.model.Designation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LectureTest {
    private Lecture lecture;
    private final Long id = 1L;
    private final Designation lectureTitle = Designation.valueOf("Introduction to Java");
    private final LectureType lectureType = LectureType.NORMAL;
    private List<Schedule> schedule;
    private Teacher teacher;
}