package com.samsung.service;

import com.samsung.domain.Category;
import com.samsung.domain.Product;
import com.samsung.repository.CategoryRepository;
import com.samsung.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Product insert(String nameProduct, String code, String nameCategory, String composition, String foto) {

        Category category = categoryRepository.findByName(nameCategory);

        if(category == null){
            category = Category.builder()
                    .name(nameCategory)
                    .build();

        }

        Product product = Product.builder()
                .name(nameProduct)
                .code(code)
                .category(category)
                .composition(composition)
                .foto(foto)
                .build();

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product update(int id, String nameProduct, String code, String nameCategory, String composition, String foto) {
        Category category = categoryRepository.findByName(nameCategory);

        if(category == null){
            category = Category.builder()
                    .name(nameCategory)
                    .build();

        }

        Product product = Product.builder()
                .id(id)
                .name(nameProduct)
                .code(code)
                .category(category)
                .composition(composition)
                .foto(foto)
                .build();

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getByName(String nameProduct) {
        return productRepository.findByName(nameProduct);
    }

    @Override
    public Product getByCode(String code) {return productRepository.findByCode(code);}

    @Override
    @Transactional
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
