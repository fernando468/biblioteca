package com.app.backend.book.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.backend.author.dto.AuthorResponse;
import com.app.backend.book.Book;
import com.app.backend.library.dto.LibraryResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {
    private UUID id;
    private String title;
    private String isbn;
    private String yearOfPublication;
    private String edition;
    private String synopsis;
    @NotNull(message = "Total pages is required")
    private Integer totalPages;
    @NotBlank(message = "Publishing Company is required")
    private String publishingCompany;
    @Valid
    private List<AuthorResponse> authors;
    @NotBlank(message = "Genre is required")
    private String category;
    @NotBlank(message = "Language is required")
    private String language;
    private FileDTO file;
    private List<LibraryResponseDTO> libraries;

    public static BookResponseDTO toDTO(Book book) {
        List<AuthorResponse> authors = book.getAuthors().stream()
                .map(AuthorResponse::toDTO)
                .collect(Collectors.toList());
        List<LibraryResponseDTO> libraries = book.getLibraries().stream()
                .map(LibraryResponseDTO::toDTO)
                .collect(Collectors.toList());
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getYearOfPublication(),
                book.getEdition(),
                book.getSynopsis(),
                book.getTotalPages(),
                book.getPublishingCompany(),
                authors,
                book.getCategory().getName(),
                book.getLanguage().getName(),
                new FileDTO(
                        book.getFile().getFileName(),
                        book.getFile().getOriginalFileName(),
                        book.getFile().getUrl()
                ),
                libraries
        );
    }
}
