package com.app.backend.library;

import java.util.UUID;

import com.app.backend.library.dto.CreateLibraryDTO;
import com.app.backend.library.dto.LibraryResponseDTO;
import com.app.backend.shared.exceptions.ResourceNotFound;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private final LibraryRepository repository;

    LibraryService(LibraryRepository eventRepository) {
        this.repository = eventRepository;
    }

	public ResponseEntity<CreateLibraryDTO> create(CreateLibraryDTO createEventDTO) {
        Library library = this.repository.save(createEventDTO.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(CreateLibraryDTO.toDTO(library));
	}

    public ResponseEntity<Page<LibraryResponseDTO>> getAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<LibraryResponseDTO> library = this.repository.findAll(pageable).map(LibraryResponseDTO::toDTO);
        return ResponseEntity.ok().body(library);
    }

    public ResponseEntity<LibraryResponseDTO> getById(UUID id) {
        Library library = this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Library with id: " + id + " not found!"));
        LibraryResponseDTO libraryResponseDTO = LibraryResponseDTO.toDTO(library);
        return ResponseEntity.ok().body(libraryResponseDTO);
    }

}
