package com.example.bibliotheque.demo.data.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDTO {
    private Long id;

    private String title;

    private String author;

    private String type;

}
