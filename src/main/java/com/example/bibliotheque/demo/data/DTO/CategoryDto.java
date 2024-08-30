package com.example.bibliotheque.demo.data.DTO;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.bibliotheque.demo.Category}
 */
@Value
public class CategoryDto implements Serializable {
    Long id;
    String name;
}