package com.example.bibliotheque.demo.data.domain;

import com.example.bibliotheque.demo.common.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class Book {

    @Id
    private String id;

    private String title;

    public void updateNonNullFields(Book updatedBook) {
        BeanUtils.copyProperties(updatedBook, this, Utils.getNullPropertyNames(updatedBook));
    }
}
