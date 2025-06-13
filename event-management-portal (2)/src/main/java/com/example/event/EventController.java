
package com.example.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("/events")
    public List<Event> getEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable Long id) {
        return service.getEvent(id);
    }

    @GetMapping("/events/upcoming")
    public List<Event> getUpcomingEvents() {
        return service.getUpcomingEvents();
    }

    @PostMapping("/event")
    public Event createEvent(@RequestBody Event event) {
        return service.createEvent(event);
    }

    @PutMapping("/event/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return service.updateEvent(id, event);
    }

    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable Long id) {
        service.deleteEvent(id);
    }
}
