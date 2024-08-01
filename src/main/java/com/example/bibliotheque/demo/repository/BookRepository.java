package com.example.bibliotheque.demo.repository;

import com.example.bibliotheque.demo.data.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}