package com.event.registration.transformers.mapper;

import com.event.registration.dto.request.CreateEventRequestDTO;
import com.event.registration.dto.request.UpdateEventRequestDTO;
import com.event.registration.dto.response.EventResponseDTO;
import com.event.registration.model.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventResponseDTO convertToDTO(Event event);

    Event convertToModel(CreateEventRequestDTO eventRequest);

    Event convertToModel(UpdateEventRequestDTO eventRequest);
}
