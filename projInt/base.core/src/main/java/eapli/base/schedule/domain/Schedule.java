package eapli.base.schedule.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Calendar;

/**
 * The type Schedule.
 *
 * @author Inês Alves (29/04/2023)
 */
@Entity
@Table
public class Schedule implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "initial_date")
    private Calendar initialDate;

    @Column(name = "final_date")
    private Calendar finalDate;

    @Column(name = "duration")
    private int duration;

    /**
     * Instantiates a new Schedule.
     */
    public Schedule() {
    }

    public Schedule(Calendar initial, int duration) {
        this.initialDate = initial;
        this.duration = duration;
        this.finalDate = createCalendar(initial);
        this.finalDate.add(Calendar.MINUTE, duration);
    }

    private Calendar createCalendar(Calendar initial) {
        // Create a new Calendar instance
        Calendar calendar = Calendar.getInstance();

        // Set the desired date and time
        calendar.set(Calendar.YEAR, initial.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, initial.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, initial.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, initial.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, initial.get(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, initial.get(Calendar.SECOND));
        return calendar;
    }

    public Schedule(final Long id, Calendar initial, Calendar finaltime) {
        this.id = id;
        this.initialDate = initial;
        this.finalDate = finaltime;
        calculateDuration(initial, finaltime);
    }

    private void calculateDuration(Calendar initial, Calendar finaltime) {
        long diffInMillis = finaltime.getTimeInMillis() - initial.getTimeInMillis();
        long diffInMinutes = diffInMillis / (60 * 1000);
        this.duration = (int) diffInMinutes;
    }

    public void changeInitialDate(Calendar initialDate) {
        this.initialDate = initialDate;
    }

    public void changeFinalDate(Calendar finalDate){
        this.finalDate = finalDate;
    }

    public void changeDurationAndFinalDate(int duration) {
        this.duration = duration;
        this.finalDate.add(Calendar.MINUTE, duration);
    }

    public Calendar initialDate() {
        return this.initialDate;
    }
    public int duration(){
        return this.duration;
    }
    public Calendar finalDate() {
        return this.finalDate;
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return this.id;
    }

    public boolean isAfterActualDate(Calendar init) {
        Calendar today = Calendar.getInstance();
        if (init.after(today)) {
            return true;
        }
        return false;
    }

    public boolean initDateIsBeforeFinal(Calendar init, Calendar fin) {
        if (fin.after(init)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", dateTime=" + initialDate.getTime() +
                ", duration=" + duration +
                '}';
    }
}
