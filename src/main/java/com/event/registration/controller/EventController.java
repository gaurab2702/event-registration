package com.event.registration.controller;

import com.event.registration.dto.request.CreateEventRequestDTO;
import com.event.registration.dto.request.UpdateEventRequestDTO;
import com.event.registration.dto.response.EventResponseDTO;
import com.event.registration.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable Long id) {
        EventResponseDTO eventResponse = eventService.fetchEvent(id);
        return ResponseEntity.ok(eventResponse);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<EventResponseDTO> createEvent(@RequestBody CreateEventRequestDTO eventRequest) {
        EventResponseDTO eventResponse = eventService.createEvent(eventRequest);
        return ResponseEntity.ok(eventResponse);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Success");
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<EventResponseDTO> updateEvent(@RequestBody UpdateEventRequestDTO eventRequest) {
        EventResponseDTO eventResponse = eventService.updateEvent(eventRequest);
        return ResponseEntity.ok(eventResponse);
    }
}
