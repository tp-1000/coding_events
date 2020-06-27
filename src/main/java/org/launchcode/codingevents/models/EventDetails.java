package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

@Entity
public class EventDetails extends AbstractEntity{

//    @OneToOne(mappedBy = "eventDetails")
//    private Event event; ////// reverse relationship it knows about the objects that refrence it

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean getIsRSVPRequired() {
        return isRSVPRequired;
    }

    public void setIsRSVPRequired(boolean RSVPRequired) {
        isRSVPRequired = RSVPRequired;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }
}
