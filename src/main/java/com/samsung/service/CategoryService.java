package com.samsung.service;

import com.samsung.domain.Category;

import java.util.List;

public interface CategoryService {

    Category insert(Category category);

    List<Category> getAll();

    Category getById(int id);

    Category getByName(String name);

    Category update(int id, String nameCategory);

    void deleteById(int id);
}
