package com.event.registration.service.impl;

import com.event.registration.dto.request.CreateEventRequestDTO;
import com.event.registration.dto.request.UpdateEventRequestDTO;
import com.event.registration.dto.response.EventResponseDTO;
import com.event.registration.exception.exceptions.ResourceNotFoundException;
import com.event.registration.model.Event;
import com.event.registration.repository.EventRepository;
import com.event.registration.service.EventService;
import com.event.registration.transformers.EventTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventTransformer eventTransformer;

    @Override
    public EventResponseDTO fetchEvent(Long id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            return eventTransformer.convertToDTO(event);
        }
        throw new ResourceNotFoundException("Event not present with id = " + id);
    }

    @Override
    public EventResponseDTO createEvent(CreateEventRequestDTO eventRequest) {
        Event event = eventTransformer.convertToModel(eventRequest);
        Event savedEvent = eventRepository.save(event);
        return eventTransformer.convertToDTO(savedEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public EventResponseDTO updateEvent(UpdateEventRequestDTO eventRequest) {
        Event event = eventTransformer.convertToModel(eventRequest);
        Event savedEvent = eventRepository.save(event);
        return eventTransformer.convertToDTO(savedEvent);
    }
}
