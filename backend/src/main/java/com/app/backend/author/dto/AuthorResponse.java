package com.app.backend.author.dto;

import java.util.UUID;

import com.app.backend.author.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {
    private UUID id;
    
    private String name;

    public static AuthorResponse toDTO(Author author) {
        return new AuthorResponse(author.getId(), author.getName());
    }

    public Author toEntity() {
        Author author = new Author();
        author.setId(this.id);
        author.setName(this.name);
        return author;
    }
}
