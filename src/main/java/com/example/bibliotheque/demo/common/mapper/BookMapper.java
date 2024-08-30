package com.example.bibliotheque.demo.common.mapper;

import com.example.bibliotheque.demo.data.domain.Category;
import com.example.bibliotheque.demo.data.DTO.BookDTO;
import com.example.bibliotheque.demo.data.domain.Book;
import org.mapstruct.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toEntity(BookDTO bookDTO);

    @Mapping(source = "category.name", target = "category")
    BookDTO toDto(Book book);

    List<BookDTO> toDto(List<Book> books);

    default Page<BookDTO> convertToBookDTOPage(Page<Book> bookPage) {
        List<BookDTO> bookDTOs = INSTANCE.toDto(bookPage.getContent());
        return new PageImpl<>(bookDTOs, PageRequest.of(bookPage.getNumber(), bookPage.getSize()), bookPage.getTotalElements());
    }

    default Category map(String value) {
        Category category = new Category();
        category.setName(value);
        return category;
    }
}