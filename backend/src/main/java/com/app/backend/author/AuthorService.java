package com.app.backend.author;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.app.backend.author.dto.AuthorResponse;
import com.app.backend.author.dto.CreateAuthorDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository repository;

    AuthorService(AuthorRepository authorRepository) {
        this.repository = authorRepository;
    }

    public ResponseEntity<AuthorResponse> create(@Valid CreateAuthorDTO createAuthorDTO) {
        Author authorCreated = this.repository.save(createAuthorDTO.toEntity());
		return ResponseEntity.ok(AuthorResponse.toDTO(authorCreated));
	}

    public ResponseEntity<List<AuthorResponse>> getAll() {
        List<AuthorResponse> authors = this.repository.findAll().stream().map(AuthorResponse::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(authors);
    }

}