package org.launchcode.codingevents.models;

public enum EventType {

    CONFERENCE("Conference"), // Call the constructor with the specific values.. the point is to create and object from within
    MEETUP("Meetup"),
    WORKSHOP("Workshop"),
    SOCIAL("Social");

    private final String displayName;

    EventType(String displayName) {
        this.displayName = displayName;
    }


    public String getDisplayName() {
        return displayName;
    }
}
