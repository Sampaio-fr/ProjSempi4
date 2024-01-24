package eapli.base.schedule.domain;

import eapli.framework.domain.model.ValueObject;

public class Duration_Schedule implements ValueObject {

    private long duration;

    public Duration_Schedule(long duration) {
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Duration_Schedule{" +
                "duration=" + duration +
                '}';
    }
}
