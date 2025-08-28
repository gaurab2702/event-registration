package com.event.registration.transformers;

import com.event.registration.dto.request.CreateEventRequestDTO;
import com.event.registration.dto.request.UpdateEventRequestDTO;
import com.event.registration.dto.response.EventResponseDTO;
import com.event.registration.model.Event;
import com.event.registration.transformers.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventTransformer {

    private final EventMapper mapper;

    public EventResponseDTO convertToDTO(Event event) {
        return mapper.convertToDTO(event);
    }

    public Event convertToModel(CreateEventRequestDTO eventRequest) {
        return mapper.convertToModel(eventRequest);
    }

    public Event convertToModel(UpdateEventRequestDTO eventRequest) {
        return mapper.convertToModel(eventRequest);
    }
}
