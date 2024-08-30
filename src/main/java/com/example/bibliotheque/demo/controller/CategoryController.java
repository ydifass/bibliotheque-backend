package com.example.bibliotheque.demo.controller;

import com.example.bibliotheque.demo.data.DTO.CategoryDTO;
import com.example.bibliotheque.demo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;
    @Operation(summary = "Get paginated list of categories")
    @GetMapping("/category-list")
    public Page<CategoryDTO> getAllCategories(
        @Parameter(in = ParameterIn.QUERY, name = "page")
            @RequestParam(defaultValue = "0", required = false)
            int page,
        @Parameter(in = ParameterIn.QUERY, name = "size")
            @RequestParam(defaultValue = "8", required = false)
            int size) {
        return categoryService.getAllCategories(page, size);
    }
}