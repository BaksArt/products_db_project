package com.samsung.service;

import com.samsung.domain.Product;

import java.util.List;

public interface ProductService {

    Product insert(
            String nameProduct,
            String nameCategory,
            String composition
    );

    Product update(
            int id,
            String nameProduct,
            String nameCategory,
            String composition
    );

    List<Product> getAll();

    Product getById(int id);

    List<Product> getByName(String nameProduct);

    void deleteById(int id);

}
