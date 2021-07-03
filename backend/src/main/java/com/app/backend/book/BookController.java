package com.app.backend.book;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.app.backend.book.dto.BookResponseDTO;
import com.app.backend.book.dto.CreateBookDTO;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    BookController(BookService bookService) {
        this.service = bookService;
    }

    @PostMapping(
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookResponseDTO> create(
            @Valid @RequestPart("book") CreateBookDTO createBookDTO,
            @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        return this.service.create(createBookDTO, file);
    }

    @PutMapping("/{id}/library/{libraryId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookResponseDTO> addBookInLibrary(@PathVariable UUID id, @PathVariable UUID libraryId) {
        return this.service.addBookInLibrary(id, libraryId);
    }

    @GetMapping
    public ResponseEntity<Page<BookResponseDTO>> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) {
        return this.service.getAll(page, size);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookResponseDTO>> searchBooks(@RequestParam(value = "title", defaultValue = "") String title) {
        return this.service.searchBooks(title);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<BookResponseDTO>> getAllByCategoryName(@PathVariable String category) {
        return this.service.getAllByCategoryName(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getById(@PathVariable UUID id) {
        return this.service.getById(id);
    }

    @GetMapping("/new")
    public ResponseEntity<List<BookResponseDTO>> getNewBooks() {
        return this.service.getNewBooks();
    }

}
