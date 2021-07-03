package com.app.backend.category;

import java.util.List;

import com.app.backend.category.dto.CategoryDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;

    CategoryController(CategoryService categoryService) {
        this.service = categoryService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO category) {
        return this.service.create(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll() {
        return this.service.getAll();
    }
}
