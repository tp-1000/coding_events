package org.launchcode.codingevents.Controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventCategory;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("events")
public class EventController {

    @Autowired // spring manages this class (dependency injection --- inversion of control) Springboot! i need a repository object!!
    // the @Repository annotation flags this is a class that should be managed by spring, it will be provided for requests and injected
    //obsever-- cannot create a interface object (needs  class that implements this interface)
    // java can create classes on the fly, runtime
    private EventRepository eventRepository;

    @Autowired
    private EventCategoryRepository eventCategoryRepository;
    // findAll, save, findById

    @GetMapping
    public String displayAllEvents(@RequestParam(required = false) Integer categoryId, Model model) {
        if (categoryId == null) {
            model.addAttribute("title", "All Events");
            model.addAttribute("events", eventRepository.findAll());
        } else {
            Optional<EventCategory> result = eventCategoryRepository.findById(categoryId);
            if(result.isEmpty()){
            model.addAttribute("title", "Invalid Category ID: " + categoryId);
            } else {
                EventCategory category = result.get();
                model.addAttribute("title", "Events in category: " + category.getName());
                model.addAttribute("events", category.getEVENT());
            }
        }


        return "events/index";
    }

    //lives at /events/create   (for a get request deliver template events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event()); // it implecitly creates "event", new Event()); ///
        model.addAttribute("categories", (eventCategoryRepository.findAll()));
        return "events/create";
    }

    @PostMapping("create")  // For a Post request to events/create (the initial GET returns the create.html) it will be redirected to the default events Get mapping.. (events/index) with the list
    public String processEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute( "title", "Create Event");
//            model.addAttribute("errorMsg", "Bad data!");
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:"; // redicrect to root
    }

    @GetMapping("delete") // not same model as in the MVC// the class
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete") // allows for no parapeters to be passed
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {

        if(eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("/edit/{eventId}")
    public String displayEditFrom(@PathVariable Integer eventId, Model model) {
        model.addAttribute("title", "Edit Event");
        Event event = eventRepository.findById(eventId).get();
        model.addAttribute("event", event);
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "events/edit";
    }

    @PostMapping("/edit")
    public String processEditForm(@ModelAttribute @Valid Event event, Errors errors, int eventId) {
        eventRepository.deleteById(eventId);
        if(errors.hasErrors()) {
            return "events/edit";
    } // very picky about parameter mapping
        eventRepository.save(event);
        return "redirect:";
    }
//
//    warrants a bit of an explanation after the trouble, @ModelAttribute matches objects meeting the criteria an dadds them to the model as
//     temp (working) object -- the other issue is that if I redirect to a handler, it makes two requests, a post and the the redirect. The post can truely be through
//    of as a processor (they all can) but the process is required for a page to render i a coherent fashion. The request of the html page directly solved the issue of id numnbers
//    getting out of sync with page requests and the (working) objects, as prior every invalid submission would increment the counter away. This method removes the current object
//     from the list and keeps track of the current (working) object, I imagine an issue could come up if someone discontets before finalizing the object into the hash, but could
//    be resolved storing a copy incomplete thought, although if it were to unexpectly say-- exit id loose eveything anyways. proably the proper solution would be a try finalize block


}
