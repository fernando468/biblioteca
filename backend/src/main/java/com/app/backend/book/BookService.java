package com.app.backend.book;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.app.backend.book.dto.BookResponseDTO;
import com.app.backend.book.dto.CreateBookDTO;
import com.app.backend.book.dto.FileDTO;
import com.app.backend.shared.exceptions.ResourceNotFound;
import com.app.backend.shared.utils.FileUtil;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BookService {
    private final BookRepository repository;

    BookService(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    public ResponseEntity<BookResponseDTO> create(CreateBookDTO createBookDTO, MultipartFile file) {
        createBookDTO.setFile(FileDTO.toDTO(FileUtil.criarArquivo(file)));
        Book book = this.repository.save(createBookDTO.toEntity());
        return ResponseEntity.ok(BookResponseDTO.toDTO(book));
    }

    public ResponseEntity<Page<BookResponseDTO>> getAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<BookResponseDTO> bookResponse = this.repository.findAll(pageable).map(BookResponseDTO::toDTO);
        return ResponseEntity.ok(bookResponse);
    }

    public ResponseEntity<BookResponseDTO> getById(UUID id) {
        Book book = this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Book with id: " + id + " not found."));
        return ResponseEntity.ok(BookResponseDTO.toDTO(book));
    }

    public ResponseEntity<BookResponseDTO> addBookInLibrary(UUID id, UUID libraryId) {
        this.repository.addBookInLibrary(id, libraryId);
        return ResponseEntity.ok().body(this.getById(id).getBody());
    }

    public ResponseEntity<List<BookResponseDTO>> searchBooks(String title) {
        List<BookResponseDTO> books = this.repository.findAllByTitleContainingIgnoreCase(title).stream()
                .map(BookResponseDTO::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(books);
    }

    public ResponseEntity<List<BookResponseDTO>> getAllByCategoryName(String category) {
        List<BookResponseDTO> books = this.repository.findAllByCategoryName(category).stream()
                .map((BookResponseDTO::toDTO))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(books);
    }

    public ResponseEntity<List<BookResponseDTO>> getNewBooks() {
        Sort sort = Sort.by(Sort.Direction.ASC, "createdAt");
        List<BookResponseDTO> books = this.repository.findAll(sort).stream()
                .map(BookResponseDTO::toDTO)
                .collect(Collectors.toList());;
        return ResponseEntity.ok().body(books);
    }
}
