package com.example.bibliotheque.demo.service;

import com.example.bibliotheque.demo.common.mapper.CategoryMapper;
import com.example.bibliotheque.demo.data.DTO.CategoryDTO;
import com.example.bibliotheque.demo.data.domain.Category;
import com.example.bibliotheque.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public Page<CategoryDTO> getAllCategories(int page, int size) {
        Page<Category> categories = categoryRepository.getAllCategory(PageRequest.of(page, size));
        return categoryMapper.convertToCategoryDTOPage(categories);
    }
}
