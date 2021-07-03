package com.app.backend.category;

import java.util.List;
import java.util.stream.Collectors;

import com.app.backend.category.dto.CategoryDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    CategoryService(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    public ResponseEntity<CategoryDTO> create(CategoryDTO category) {
        Category categoryResponse = this.repository.save(category.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryDTO.toDTO(categoryResponse));
    }

    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<CategoryDTO> categories = this.repository.findAll().stream()
                .map(CategoryDTO::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(categories);
    }
}
