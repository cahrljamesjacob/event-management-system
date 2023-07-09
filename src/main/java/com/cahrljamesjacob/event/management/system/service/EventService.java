package com.cahrljamesjacob.event.management.system.service;

import com.cahrljamesjacob.event.management.system.model.Event;
import com.cahrljamesjacob.event.management.system.model.EventDto;
import com.cahrljamesjacob.event.management.system.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event addEvent(EventDto eventDto) {
        Event eventToAdd = mapEventDtoToEventEntity(eventDto);
        return eventRepository.save(eventToAdd);
    }

    private Event mapEventDtoToEventEntity(EventDto eventDto) {
        return Event
                .builder()
                .title(eventDto.getTitle())
                .dateTime(eventDto.getDateTime())
                .description(eventDto.getDescription())
                .eventOrganizer(eventDto.getEventOrganizer())
                .participants(eventDto.getParticipants())
                .location(eventDto.getLocation())
                .status(eventDto.getStatus())
                .build();
    }

    public Event getEventById(long id) {
        return getEventUsingID(id);
    }

    public void deleteEventById(long id) {
        Event eventToDelete = getEventUsingID(id);
        eventRepository.delete(eventToDelete);
    }

    private Event getEventUsingID(long id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Resource not found"));
    }

    public Event updateEvent(long id, EventDto eventDto) {
        Event eventToUpdate = getEventUsingID(id);
        Event updatedEvent = eventToUpdate
                .toBuilder()
                .title(eventDto.getTitle())
                .dateTime(eventDto.getDateTime())
                .location(eventDto.getLocation())
                .eventOrganizer(eventDto.getEventOrganizer())
                .location(eventDto.getLocation())
                .participants(eventDto.getParticipants())
                .build();
        return eventRepository.save(updatedEvent);
    }
}
