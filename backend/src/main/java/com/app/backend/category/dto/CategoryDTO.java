package com.app.backend.category.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.app.backend.category.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private UUID id;
    @NotBlank(message = "Name is required")
    private String name;

    public static CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }

    public Category toEntity() {
        return new Category(this.name);
    }
}
