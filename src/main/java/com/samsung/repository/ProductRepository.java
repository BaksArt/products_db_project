package com.samsung.repository;


import com.samsung.domain.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Override
    @EntityGraph(attributePaths = {"name", "code", "category", "composition"})
    List<Product> findAll();

    List<Product> findByName(String name);

    Product findByCode(String code);
}
