package com.event.registration.service;

import com.event.registration.dto.request.CreateEventRequestDTO;
import com.event.registration.dto.request.UpdateEventRequestDTO;
import com.event.registration.dto.response.EventResponseDTO;

public interface EventService {

    EventResponseDTO fetchEvent(Long id);

    EventResponseDTO createEvent(CreateEventRequestDTO eventRequest);

    void deleteEvent(Long id);

    EventResponseDTO updateEvent(UpdateEventRequestDTO eventRequest);
}
