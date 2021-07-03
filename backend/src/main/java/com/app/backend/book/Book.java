package com.app.backend.book;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.app.backend.author.Author;
import com.app.backend.category.Category;
import com.app.backend.language.Language;
import com.app.backend.library.Library;
import com.app.backend.shared.models.BaseEntity;
import com.app.backend.shared.models.File;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String yearOfPublication;

    @Column(nullable = false)
    private String edition;

    @Column(nullable = false, columnDefinition = "text")
    private String synopsis;

    @Column(nullable = false)
    private Integer totalPages;

    @Column(nullable = false)
    private String publishingCompany;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "BOOK_AUTHORS",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORS_ID")
    )
    private List<Author> authors;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Language language;

    @OneToOne(cascade = CascadeType.ALL)
    private File file;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "LIBRARY_ID")
    )
    private List<Library> libraries;
}
