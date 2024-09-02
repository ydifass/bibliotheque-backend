package com.example.bibliotheque.demo.repository;

import com.example.bibliotheque.demo.data.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE "
            + "(COALESCE(:startDate, NULL) IS NULL AND COALESCE(:endDate, NULL) IS NULL) "
            + "OR b.publicationDate BETWEEN :startDate AND :endDate")
    Page<Book> getAllBooks(
            @Param("startDate") Instant startDate,
            @Param("endDate") Instant endDate,
            Pageable pageable);
}