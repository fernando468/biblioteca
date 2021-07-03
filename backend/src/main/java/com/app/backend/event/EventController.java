package com.app.backend.event;

import java.util.UUID;

import javax.validation.Valid;

import com.app.backend.event.dto.CreateEventDTO;
import com.app.backend.event.dto.EventResponseDTO;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService service;

    EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EventResponseDTO> create(@Valid @RequestBody CreateEventDTO event) {
        return this.service.create(event);
    }

    @GetMapping
    public ResponseEntity<Page<EventResponseDTO>> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) {
        return this.service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getById(@PathVariable UUID id) {
        return this.service.getById(id);
    }

    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<EventResponseDTO> update(@PathVariable UUID id, @PathVariable String status) {
        return this.service.update(id, status);
    }

}
