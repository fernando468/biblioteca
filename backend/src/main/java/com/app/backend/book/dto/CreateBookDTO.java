package com.app.backend.book.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.backend.author.Author;
import com.app.backend.author.dto.AuthorResponse;
import com.app.backend.book.Book;
import com.app.backend.category.Category;
import com.app.backend.language.Language;
import com.app.backend.shared.models.File;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookDTO {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "ISBN is required")
    private String isbn;

    @NotBlank(message = "Year publication is required")
    private String yearOfPublication;

    @NotBlank(message = "Edition is required")
    private String edition;

    @NotBlank(message = "Synopsis is required")
    private String synopsis;

    @NotNull(message = "Total pages is required")
    private Integer totalPages;

    @NotBlank(message = "Publishing Company is required")
    private String publishingCompany;

    @Valid
    private List<AuthorResponse> authors;

    @NotBlank(message = "Genre is required")
    private String genreId;

    @NotBlank(message = "Language is required")
    private String languageId;

    private FileDTO file;

    public Book toEntity() {
        List<Author> authors = this.getAuthors().stream()
                .map(AuthorResponse::toEntity).collect(Collectors.toList());
        Language language = new Language();
        language.setId(UUID.fromString(this.languageId));
        Category category = new Category();
        category.setId(UUID.fromString(this.genreId));
        return new Book(
                this.title,
                this.isbn,
                this.yearOfPublication,
                this.edition,
                this.synopsis,
                this.totalPages,
                this.publishingCompany,
                authors,
                category,
                language,
                new File(
                        this.getFile().getFileName(),
                        this.getFile().getOriginalFileName(),
                        this.getFile().getUrl()
                ),
                new ArrayList<>()
        );
    }
}
