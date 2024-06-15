package com.example.books.controllers;

import com.example.books.domain.Book;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class BookController {
    @GetMapping(path = "/books")
    public Book getBook() {
        return Book.builder()
                .isbn("Book_1")
                .title("Sach giao khoa toan")
                .author("Nguyen, Son Chu")
                .yearPublished("2010")
                .build();
    }

    @PostMapping(path = "/books")
    public Book createBook(@RequestBody final Book book) {
        log.info("Got book: " + book.toString());
        return book;
    }
}
