package com.example.bibliotheque.demo.common.mapper;

import com.example.bibliotheque.demo.data.DTO.CategoryDTO;
import com.example.bibliotheque.demo.data.domain.Category;
import org.mapstruct.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDto(Category category);

    List<CategoryDTO> toDto(List<Category> categories);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(CategoryDTO categoryDTO, @MappingTarget Category category);

    default Page<CategoryDTO> convertToCategoryDTOPage(Page<Category> categoryPage) {
        List<CategoryDTO> categoryDTOs = toDto(categoryPage.getContent());
        return new PageImpl<>(categoryDTOs, PageRequest.of(categoryPage.getNumber(), categoryPage.getSize()), categoryPage.getTotalElements());
    }
}