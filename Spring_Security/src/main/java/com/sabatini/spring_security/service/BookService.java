package com.sabatini.spring_security.service;

import com.sabatini.spring_security.model.Book;
import com.sabatini.spring_security.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        List<Book> booksList = new ArrayList<>();
        bookRepository.findAll().forEach(booksList::add);
        return booksList;
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Book registerBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        bookRepository.findById(id).orElseThrow(RuntimeException::new);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
