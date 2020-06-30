package org.launchcode.codingevents.models.dto;

import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.Tags;

import javax.validation.constraints.NotNull;

//naming convention DTO and combining the two classes being comingned
//pass tag and event around in a bundle in the conterolled
public class EventTagDTO {

    @NotNull
    private Event event;

    @NotNull
    private Tags tag;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Tags getTag() {
        return tag;
    }

    public void setTag(Tags tag) {
        this.tag = tag;
    }
}
