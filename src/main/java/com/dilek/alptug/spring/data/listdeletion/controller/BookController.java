package com.dilek.alptug.spring.data.listdeletion.controller;

import com.dilek.alptug.spring.data.listdeletion.model.Book;
import com.dilek.alptug.spring.data.listdeletion.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private BookService bookService;

    public BookController(@Autowired BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books/populate")
    // curl -X POST http://localhost:8080/books/populate
    public void populateDB() {
        bookService.populateDBWithPredefinedBooks();
    }

    @GetMapping("/books")
    // curl -X GET http://localhost:8080/books
    public List<Book> fetchAllBooks() {
        return bookService.fetchAllBooks();
    }

    @DeleteMapping("books/aslist")
    // curl -X DELETE http://localhost:8080/books/aslist
    public void deleteAllBooksAsList() {
        bookService.deleteAllBooksAsList();
    }

    @DeleteMapping("books/iteration")
    // curl -X DELETE http://localhost:8080/books/iteration
    public void deleteAllBooksViaIteration() {
        bookService.deleteAllBooksViaIteration();
    }
}
