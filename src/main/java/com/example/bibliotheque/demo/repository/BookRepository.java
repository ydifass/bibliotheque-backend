package com.example.bibliotheque.demo.repository;

import com.example.bibliotheque.demo.data.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}