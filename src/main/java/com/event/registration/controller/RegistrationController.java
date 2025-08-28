package com.event.registration.controller;

import com.event.registration.dto.request.RegistrationRequestDTO;
import com.event.registration.dto.response.RegistrationResponseDTO;
import com.event.registration.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationResponseDTO> getRegistration(@PathVariable Long id) {
        RegistrationResponseDTO registrationResponse = registrationService.fetchRegistration(id);
        return ResponseEntity.ok(registrationResponse);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<RegistrationResponseDTO> createRegistration(@RequestBody RegistrationRequestDTO registrationRequest) {
        RegistrationResponseDTO registration = registrationService.createRegistration(registrationRequest);
        return ResponseEntity.ok(registration);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RegistrationResponseDTO>> getRegistrationByUserId(@PathVariable Long userId) {
        List<RegistrationResponseDTO> registrationResponses = registrationService.fetchRegistrationByUserId(userId);
        return ResponseEntity.ok(registrationResponses);
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<RegistrationResponseDTO>> getRegistrationByEventId(@PathVariable Long eventId) {
        List<RegistrationResponseDTO> registrationResponses = registrationService.fetchRegistrationByEventId(eventId);
        return ResponseEntity.ok(registrationResponses);
    }
}
