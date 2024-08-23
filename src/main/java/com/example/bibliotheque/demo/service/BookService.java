package com.example.bibliotheque.demo.service;

import com.example.bibliotheque.demo.common.mapper.BookMapper;
import com.example.bibliotheque.demo.data.DTO.BookDTO;
import com.example.bibliotheque.demo.data.domain.Book;
import com.example.bibliotheque.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Page<BookDTO> getAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = bookRepository.getAllBooks(pageable);
        return bookMapper.convertToBookDTOPage(books);
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
