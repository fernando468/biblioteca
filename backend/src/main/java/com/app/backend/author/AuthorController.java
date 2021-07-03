package com.app.backend.author;

import java.util.List;

import javax.validation.Valid;

import com.app.backend.author.dto.AuthorResponse;
import com.app.backend.author.dto.CreateAuthorDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService service;
    
    AuthorController(AuthorService authorService) {
        this.service = authorService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AuthorResponse> create(@Valid @RequestBody CreateAuthorDTO createAuthorDTO) {
        return this.service.create(createAuthorDTO);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAll() {
        return this.service.getAll();
    }
}
