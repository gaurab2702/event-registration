package com.event.registration.transformers;

import com.event.registration.dto.request.RegistrationRequestDTO;
import com.event.registration.dto.response.RegistrationResponseDTO;
import com.event.registration.model.Registration;
import com.event.registration.transformers.mapper.RegistrationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RegistrationTransformer {

    private final RegistrationMapper mapper;

    public Registration convertToModel(RegistrationRequestDTO registrationRequest) {
        return mapper.convertToModel(registrationRequest);
    }

    public RegistrationResponseDTO convertToDTO(Registration registration) {
        return mapper.convertToDTO(registration);
    }

    public List<RegistrationResponseDTO> convertToDTOs(List<Registration> registrations) {
        return mapper.convertToDTOs(registrations);
    }
}
