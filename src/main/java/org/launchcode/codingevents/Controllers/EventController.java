package org.launchcode.codingevents.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", events);
        return "events/index";
    }

    //lives at /events/create   (for a get request deliver template events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    @PostMapping("create")  // For a Post request to events/create (the initial GET returns the create.html) it will be redirected to the default events Get mapping.. (events/index) with the list
    public String createEvent(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:"; // redicrect to root
    }
}
