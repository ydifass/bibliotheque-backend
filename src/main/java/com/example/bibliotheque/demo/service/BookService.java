package com.example.bibliotheque.demo.service;

import com.example.bibliotheque.demo.data.domain.Book;
import com.example.bibliotheque.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    public Page<Book> getAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.getAllBooks(pageable);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book) throws Exception {
        Book originalBook = bookRepository.
                findById(book.getId()).orElseThrow(() -> new Exception("Book not found"));
        originalBook.updateNonNullFields(book);
        return bookRepository.save(originalBook);
    }
}
