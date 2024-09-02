package com.example.bibliotheque.demo.data.DTO;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDTO {
    private Long id;

    private String title;

    private String author;

    private String category;

    private Instant publicationDate;

}
