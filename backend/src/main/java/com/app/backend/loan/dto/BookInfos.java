package com.app.backend.loan.dto;

import java.util.UUID;

import com.app.backend.book.Book;
import com.app.backend.book.dto.FileDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookInfos {
    private UUID id;
    private String title;

    private FileDTO file;

    public static BookInfos toDTO(Book book) {
        return new BookInfos(
                book.getId(),
                book.getTitle(),
                FileDTO.toDTO(book.getFile())
        );
    }
}
