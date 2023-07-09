package com.cahrljamesjacob.event.management.system.controller;

import com.cahrljamesjacob.event.management.system.model.Event;
import com.cahrljamesjacob.event.management.system.model.EventDto;
import com.cahrljamesjacob.event.management.system.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@CrossOrigin
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> getEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody EventDto eventDto) {
        Event eventAdded = eventService.addEvent(eventDto);
        return ResponseEntity.ok(eventAdded);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEventById(@PathVariable long id) {
        eventService.deleteEventById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable long id, @RequestBody EventDto eventDto) {
        Event updatedEvent = eventService.updateEvent(id, eventDto);
        return ResponseEntity.ok(updatedEvent);
    }
}
