package com.samsung.service;

import com.samsung.domain.Category;
import com.samsung.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category insert(Category author) {
        //...

        return categoryRepository.save(author);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Category getByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    @Transactional
    public Category update(int id, String nameCategory) {
        Category category = Category.builder()
                .id(id)
                .name(nameCategory)
                .build();
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
