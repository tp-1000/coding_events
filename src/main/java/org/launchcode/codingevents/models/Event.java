package org.launchcode.codingevents.models;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event extends AbstractEntity{

    @Size(min = 3, max = 50, message = "Name must be between 3-50 characters")
    @NotBlank(message="Name is required")
    private String name;

    @ManyToOne
    @NotNull(message = "Category is required")
    private EventCategory eventCategory;

    @OneToOne(cascade = CascadeType.ALL) //save event needs to save event details object -- specifies all database operations cascade
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @ManyToMany
    private final List<Tags> tags = new ArrayList<>();

    public Event(EventCategory eventCategory, String name) {
        this.eventCategory = eventCategory;
        this.name = name;
    }

    public Event() {};

    @Override
    public String toString() {
        return name;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void addTag(Tags tag) {
        tags.add(tag);
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
