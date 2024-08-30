package com.example.bibliotheque.demo.controller;

import com.example.bibliotheque.demo.data.DTO.BookDTO;
import com.example.bibliotheque.demo.data.domain.Book;
import com.example.bibliotheque.demo.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books/api")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class BookController {

    private final BookService bookService;

    @Operation(summary = "Get paginated list of books")
    @GetMapping("/book-list")
    public Page<BookDTO> getAllBooks(
        @Parameter(in = ParameterIn.QUERY, name = "sortBy")
            @RequestParam(defaultValue = "title", required = false)
            String sortBy,
        @Parameter(in = ParameterIn.QUERY, name = "sortBy")
            @RequestParam(defaultValue = "ASC", required = false)
            String sortDirection,
        @Parameter(in = ParameterIn.QUERY, name = "page")
            @RequestParam(defaultValue = "0", required = false)
            int page,
        @Parameter(in = ParameterIn.QUERY, name = "size")
            @RequestParam(defaultValue = "8", required = false)
            int size) {
        return bookService.getAllBooks(page, size, sortBy, sortDirection);
    }

    @PostMapping("/add-book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/delete-book/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @PutMapping("/update-book")
    public Book updateBook(@RequestBody Book book) throws Exception {
        return bookService.updateBook(book);
    }
}
