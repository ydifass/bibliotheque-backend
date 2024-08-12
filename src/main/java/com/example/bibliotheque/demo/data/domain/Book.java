package com.example.bibliotheque.demo.data.domain;

import com.example.bibliotheque.demo.common.utils.Utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String type;

    public void updateNonNullFields(Book updatedBook) {
        BeanUtils.copyProperties(updatedBook, this, Utils.getNullPropertyNames(updatedBook));
    }
}
