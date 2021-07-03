package com.app.backend.language;

import java.util.List;
import java.util.stream.Collectors;

import com.app.backend.language.dto.LanguageDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    private final LanguageRepository repository;

    LanguageService(LanguageRepository languageRepository) {
        this.repository = languageRepository;
    }

    public ResponseEntity<LanguageDTO> create(LanguageDTO language) {
        Language languageCreated = this.repository.save(language.toEntity());
        return ResponseEntity.ok().body(LanguageDTO.toDTO(languageCreated));
    }

    public ResponseEntity<List<LanguageDTO>> getAll() {
        List<LanguageDTO> languages = this.repository.findAll().stream()
                .map(LanguageDTO::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(languages);
    }
}
