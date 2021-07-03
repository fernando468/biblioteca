package com.app.backend.library;

import java.util.UUID;

import javax.validation.Valid;

import com.app.backend.library.dto.CreateLibraryDTO;
import com.app.backend.library.dto.LibraryResponseDTO;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {
    private final LibraryService service;

    LibraryController(LibraryService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CreateLibraryDTO> create(@Valid @RequestBody CreateLibraryDTO criarBiblioteca) {
        return this.service.create(criarBiblioteca);
    }

    @GetMapping
    public ResponseEntity<Page<LibraryResponseDTO>> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "4") int size
    ) {
        return this.service.getAll(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryResponseDTO> getById(@PathVariable UUID id) {
        return this.service.getById(id);
    }

}
