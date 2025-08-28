package com.event.registration.transformers.mapper;

import com.event.registration.dto.request.RegistrationRequestDTO;
import com.event.registration.dto.response.RegistrationResponseDTO;
import com.event.registration.model.Registration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {

    Registration convertToModel(RegistrationRequestDTO registrationRequest);

    RegistrationResponseDTO convertToDTO(Registration registration);

    List<RegistrationResponseDTO> convertToDTOs(List<Registration> registrations);
}
