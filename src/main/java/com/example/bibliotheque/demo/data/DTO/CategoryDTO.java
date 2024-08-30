package com.example.bibliotheque.demo.data.DTO;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDTO{
    Long id;

    String name;
}