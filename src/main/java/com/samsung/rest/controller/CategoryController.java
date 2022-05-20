package com.samsung.rest.controller;


import com.samsung.domain.Category;
import com.samsung.rest.dto.CategoryDto;
import com.samsung.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/category")
    public List<CategoryDto> getAllCategory(){
        return categoryService.getAll()
                .stream()
                .map(CategoryDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/category")
    public CategoryDto insertCategory(@RequestBody CategoryDto categoryDto){
        Category category = categoryService.insert(CategoryDto.toDomainObject(categoryDto));
        return CategoryDto.toDto(category);
    }

    @PutMapping("category/{id}")
    public CategoryDto updateCategory(@PathVariable int id,
                                  @RequestParam String name){

        Category category = categoryService.update(id, name);
        return CategoryDto.toDto(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteById(id);
    }

    @GetMapping("/category/id")
    public CategoryDto getCategoryById(@PathVariable int id){
        Category category = categoryService.getById(id);
        return CategoryDto.toDto(category);

    }
}
