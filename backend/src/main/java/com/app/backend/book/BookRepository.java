package com.app.backend.book;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "" +
            "INSERT INTO book_libraries (book_id, library_id) " +
            "VALUES (?, ?);" +
            "")
    void addBookInLibrary(UUID bookId, UUID libraryId);

    List<Book> findAllByTitleContainingIgnoreCase(String title);

    List<Book> findAllByCategoryName(String category);
}
