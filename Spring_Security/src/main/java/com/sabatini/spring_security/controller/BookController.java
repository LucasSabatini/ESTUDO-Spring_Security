package com.sabatini.spring_security.controller;

import com.sabatini.spring_security.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<Book> registerBook(Book book) {
        return ResponseEntity.created(bookService.registerBook(book));
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(Long id, Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBook(Long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}
