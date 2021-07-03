package com.app.backend.book.dto;

import com.app.backend.shared.models.File;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private String fileName;
    private String originalFileName;
    private String url;

    public static FileDTO toDTO(File file) {
        return new FileDTO(file.getFileName(), file.getOriginalFileName(), file.getUrl());
    }
}
