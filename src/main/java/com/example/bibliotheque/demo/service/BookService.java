package com.example.bibliotheque.demo.service;

import com.example.bibliotheque.demo.data.domain.Book;
import com.example.bibliotheque.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book) throws Exception {
        Book originalBook = bookRepository.
                findById(book.getId()).orElseThrow(() -> new Exception("Book not found"));
        originalBook.updateNonNullFields(book);
        return bookRepository.save(originalBook);
    }
}
