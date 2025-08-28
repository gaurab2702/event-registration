package com.event.registration.service.impl;

import com.event.registration.dto.request.RegistrationRequestDTO;
import com.event.registration.dto.response.RegistrationResponseDTO;
import com.event.registration.exception.exceptions.ResourceNotFoundException;
import com.event.registration.model.Registration;
import com.event.registration.repository.RegistrationRepository;
import com.event.registration.service.RegistrationService;
import com.event.registration.transformers.RegistrationTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final RegistrationTransformer transformer;

    @Override
    public RegistrationResponseDTO fetchRegistration(Long id) {
        Optional<Registration> registrationOptional = registrationRepository.findById(id);
        if (registrationOptional.isPresent()) {
            Registration registration = registrationOptional.get();
            return transformer.convertToDTO(registration);
        }
        throw new ResourceNotFoundException("Registration not present with id = " + id);
    }

    @Override
    public RegistrationResponseDTO createRegistration(RegistrationRequestDTO registrationRequest) {
        Registration registration = transformer.convertToModel(registrationRequest);
        Registration saved = registrationRepository.save(registration);
        return transformer.convertToDTO(saved);
    }

    @Override
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    @Override
    public List<RegistrationResponseDTO> fetchRegistrationByUserId(Long userId) {
        List<Registration> registrations = registrationRepository.findByUserId(userId);
        return transformer.convertToDTOs(registrations);
    }

    @Override
    public List<RegistrationResponseDTO> fetchRegistrationByEventId(Long eventId) {
        List<Registration> registrations = registrationRepository.findByEventId(eventId);
        return transformer.convertToDTOs(registrations);
    }
}
