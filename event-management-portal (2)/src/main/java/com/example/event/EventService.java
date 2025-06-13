
package com.example.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repository;

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Event getEvent(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Event> getUpcomingEvents() {
        return repository.findByDateAfter(LocalDate.now());
    }

    public Event createEvent(Event event) {
        return repository.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = repository.findById(id).orElseThrow();
        event.setName(eventDetails.getName());
        event.setDate(eventDetails.getDate());
        event.setVenue(eventDetails.getVenue());
        event.setDescription(eventDetails.getDescription());
        return repository.save(event);
    }

    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }
}
