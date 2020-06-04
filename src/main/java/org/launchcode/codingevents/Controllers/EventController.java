package org.launchcode.codingevents.Controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute( "title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    //lives at /events/create   (for a get request deliver template events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    @PostMapping("create")  // For a Post request to events/create (the initial GET returns the create.html) it will be redirected to the default events Get mapping.. (events/index) with the list
    public String processEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:"; // redicrect to root
    }

    @GetMapping("delete") // not same model as in the MVC// the class
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete") // allows for no parapeters to be passed
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {

        if(eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("/edit/{eventId}")
    public String displayEditFrom(Model model, @PathVariable int eventId) {
        Event event = EventData.getEvent(eventId);
        model.addAttribute("event", event);
     return "events/edit";
    }

    @PostMapping("/edit")
    public String processEditForm(int eventId, String name, String description) {
        Event event = EventData.getEvent(eventId);
        event.setName(name);
        event.setDescription(description);
        return "redirect:";
    }


}
