package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {
    
    //needs place to put events (map is interface -- code to interface types)
    private static final Map<Integer, Event> events = new HashMap<>();
    
    // get all events (Collections and interface --- we will use iterable interface-- allows looping over 
    public static Collection<Event> getAll() {
        return events.values();
    }
    
    // get a single event
    public static Event getEvent(int id) {
        return events.get(id);
    }
    
    // add event
    public static void add(Event event) {
        events.put(event.getId(), event);
    } 
    
    // remove event
    public static void remove(int id) {
        events.remove(id);
    }
    
}
