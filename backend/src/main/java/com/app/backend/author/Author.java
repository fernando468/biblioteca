package com.app.backend.author;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.app.backend.book.Book;
import com.app.backend.shared.models.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
