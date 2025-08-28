package com.event.registration.service;

import com.event.registration.dto.request.RegistrationRequestDTO;
import com.event.registration.dto.response.RegistrationResponseDTO;

import java.util.List;

public interface RegistrationService {

    RegistrationResponseDTO fetchRegistration(Long id);

    RegistrationResponseDTO createRegistration(RegistrationRequestDTO registrationRequest);

    void deleteRegistration(Long id);

    List<RegistrationResponseDTO> fetchRegistrationByUserId(Long userId);

    List<RegistrationResponseDTO> fetchRegistrationByEventId(Long eventId);
}
