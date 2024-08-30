package com.example.bibliotheque.demo.data.domain;

import com.example.bibliotheque.demo.Category;
import com.example.bibliotheque.demo.common.utils.Utils;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public void updateNonNullFields(Book updatedBook) {
        BeanUtils.copyProperties(updatedBook, this, Utils.getNullPropertyNames(updatedBook));
    }
}
