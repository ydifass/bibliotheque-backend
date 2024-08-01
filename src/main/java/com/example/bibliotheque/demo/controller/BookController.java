package com.example.bibliotheque.demo.controller;

import com.example.bibliotheque.demo.data.domain.Book;
import com.example.bibliotheque.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books/api")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping("/book-list")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add-book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/delete-book")
    public void deleteBook(@RequestParam String id) {
        bookService.deleteBookById(id);
    }

    @PutMapping("/update-book")
    public Book updateBook(@RequestBody Book book) throws Exception {
        return bookService.updateBook(book);
    }
}
