package com.app.backend.language;

import java.util.List;

import com.app.backend.language.dto.LanguageDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
    private final LanguageService service;

    LanguageController(LanguageService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LanguageDTO> create(@RequestBody LanguageDTO language) {
        return this.service.create(language);
    }

    @GetMapping
    public ResponseEntity<List<LanguageDTO>> getAll() {
        return this.service.getAll();
    }
}
