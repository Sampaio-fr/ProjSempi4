package eapli.base.timetable.domain;

import eapli.base.schedule.domain.Schedule;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Schedule.
 *
 */
@Entity
@Table(name = "TimeTable")
public class TimeTable implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany (cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<Schedule> listSchedules;

    /**
     * Instantiates a new Timetable
     */
    public TimeTable(){
        this.listSchedules = new ArrayList<>();
    }

    public Long identity() {
        return id;
    }

    public List<Schedule> listSchedules() {
        return listSchedules;
    }

    public void replaceListSchedules(List<Schedule> listSchedules) {
        this.listSchedules = listSchedules;
    }

    public void addSchedules(Schedule schedules) {
        this.listSchedules.add(schedules);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

}
