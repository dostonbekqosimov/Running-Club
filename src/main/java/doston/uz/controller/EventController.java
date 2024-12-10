package doston.uz.controller;

import doston.uz.dto.ClubDTO;
import doston.uz.dto.EventDTO;
import doston.uz.model.Event;
import doston.uz.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("")
    public String getEventPage(Model model) {
        List<EventDTO> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        model.addAttribute("title", "Events");
        return "events-list";
    }

    @GetMapping("/{eventId}")
    public String viewDetail(@PathVariable("eventId") Long id, Model model) {
        EventDTO eventDTO = eventService.findEventById(id);
        model.addAttribute("event", eventDTO);
        model.addAttribute("title", "Event Detail");
        return "events-detail";
    }

    @GetMapping("/search")
    public String searchClub(@RequestParam(value = "title") String title, Model model) {
        List<EventDTO> events = eventService.searchEvents(title);
        model.addAttribute("events", events);
        return "clubs-list";
    }

    @GetMapping("/{clubId}/event")
    public String getEventPage(@PathVariable("clubId") Long id, Model model) {
        List<EventDTO> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        model.addAttribute("title", "Events");
        return "events-list";
    }

    @GetMapping("/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") Long id, Model model) {

        Event event = new Event();
        model.addAttribute("clubId", id);
        model.addAttribute("event", event);
        model.addAttribute("title", "Create Event");
        return "events-form";
    }

    @GetMapping("/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") Long eventId, Model model) {
        EventDTO eventDTO = eventService.findEventById(eventId);
        model.addAttribute("event", eventDTO);
        model.addAttribute("title", "Edit Event");
        return "events-edit";
    }

    @GetMapping("/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") Long eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }

    @PostMapping("/{clubId}/save")
    public String saveEvent(@PathVariable("clubId") Long id,
                            @Valid @ModelAttribute("event") EventDTO evenDTO,
                            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "events-form";
        }
        eventService.createEvent(id, evenDTO);
        return "redirect:/clubs/" + id;
    }

    @PostMapping("/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") Long id,
                             @Valid @ModelAttribute("club") EventDTO event,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "events-edit";
        }
        EventDTO eventDTO = eventService.findEventById(id);
        event.setId(id);
        event.setClub(eventDTO.getClub());

        eventService.updateEvent(event);

        return "redirect:/events";
    }
}
