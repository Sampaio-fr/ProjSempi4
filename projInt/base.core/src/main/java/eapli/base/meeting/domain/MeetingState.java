package eapli.base.meeting.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.NoArgsConstructor;



public enum MeetingState   {

    CANCELLED,
    /**
     * Scheduled meeting state.
     */
    SCHEDULED,
    /**
     * Occurring meeting state.
     */
    OCCURRING,
    /**
     * Finished meeting state.
     */
    FINISHED;

}
