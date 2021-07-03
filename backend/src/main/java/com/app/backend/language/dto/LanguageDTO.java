package com.app.backend.language.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.app.backend.language.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LanguageDTO {
    private UUID id;
    @NotBlank(message = "Name is required")
    private String name;

    public static LanguageDTO toDTO(Language language) {
        return new LanguageDTO(language.getId(), language.getName());
    }

    public Language toEntity() {
        return new Language(this.name);
    }
}
