package com.app.backend.author.dto;

import java.util.ArrayList;

import com.app.backend.author.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorDTO {
    private String name;

    public Author toEntity() {
        return new Author(this.getName(), new ArrayList<>());
    }
}
