package com.app.backend.event;

import java.util.UUID;

import com.app.backend.event.dto.CreateEventDTO;
import com.app.backend.event.dto.EventResponseDTO;
import com.app.backend.shared.exceptions.ResourceNotFound;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository repository;

    EventService(EventRepository eventRepository) {
        this.repository = eventRepository;
    }

	public ResponseEntity<EventResponseDTO> create(CreateEventDTO createEvent) {
        Event eventCreated = this.repository.save(createEvent.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(EventResponseDTO.toDTO(eventCreated));
	}

    public ResponseEntity<Page<EventResponseDTO>> getAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<EventResponseDTO> eventResponse = this.repository.findAll(pageable).map(EventResponseDTO::toDTO);
        return ResponseEntity.ok().body(eventResponse);
    }

    public ResponseEntity<EventResponseDTO> getById(UUID id) {
        Event eventResponse = this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Event with id: " + id + " not found!"));
        EventResponseDTO eventResponseDTO = EventResponseDTO.toDTO(eventResponse);
        return ResponseEntity.ok().body(eventResponseDTO);
    }

    public ResponseEntity<EventResponseDTO> update(UUID id, String status) {
        int enumOrdinal = Status.valueOf(status).ordinal();
        this.repository.updateStatus(enumOrdinal, id);
        EventResponseDTO event = this.getById(id).getBody();
        return ResponseEntity.ok().body(event);
    }
}
