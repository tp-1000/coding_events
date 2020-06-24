package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;

    @Size(min = 3, max = 50, message = "Name must be between 3-50 characters")
    @NotBlank(message="Name is required")
    private String name;
    @Size(max = 500, message = "Description to long!")
    private String description;

    @NotBlank(message="Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotEmpty(message = "Required")
    @Digits(integer = 5, fraction = 0, message = "Provide 5 digit zipcode")
    private String zipcode;

    @AssertTrue(message = "Must be true")
    private boolean isRSVPRequired;

    @Min(message = "Must have at least one guest.", value = 1)
    @Max(message = "Only 999 guest allowed.", value = 999)
    private String attendees;

    @Enumerated(EnumType.ORDINAL)
    private EventType type;



    public Event(EventType type, String name, String description, String contactEmail, String zipcode, @Min(message = "Have at least one guest.", value = 1) @Max(message = "Only 999 guest allowed.", value = 999) String attendees, @AssertTrue(message = "Must be true") boolean isRSVPRequired) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.zipcode = zipcode;

        this.attendees = attendees;
        this.isRSVPRequired = isRSVPRequired;
    }

    public Event() {};

    @Override
    public String toString() {
        return name;
    }

    public EventType getType() {return type; }

    public void setType(EventType type) {
        this.type = type;
    }

    public boolean getIsRSVPRequired() {
        return isRSVPRequired;
    }

    public void setIsRSVPRequired(boolean isRSVPRequired) {
        this.isRSVPRequired = isRSVPRequired;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
