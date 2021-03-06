package com.samsung.service;

import com.samsung.domain.Product;

import java.util.List;

public interface ProductService {

    Product insert(
            String nameProduct,
            String code,
            String nameCategory,
            String composition,
            String foto
    );

    Product update(
            int id,
            String nameProduct,
            String code,
            String nameCategory,
            String composition,
            String foto
    );

    List<Product> getAll();

    Product getById(int id);

    List<Product> getByName(String nameProduct);

    Product getByCode(String code);

    void deleteById(int id);

}
