package com.samsung.rest.controller;

import com.samsung.domain.Product;
import com.samsung.rest.dto.ProductDto;
import com.samsung.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/product")
    public List<ProductDto> getAllProduct(){
        List<ProductDto> productDtoList = productService.getAll().stream().map(ProductDto::toDto).collect(Collectors.toList());
        return productDtoList;
    }

    @PostMapping("/product")
    public ProductDto insertProduct(@RequestParam String nameProduct,
                                    @RequestParam String code,
                              @RequestParam String nameCategory,
                              @RequestParam String composition, @RequestParam String foto){
        Product product = productService.insert(nameProduct, code, nameCategory, composition, foto);

        return ProductDto.toDto(product);
    }

    @PutMapping("/product/{id}")
    public ProductDto updateProduct(@PathVariable int id, @RequestParam String nameProduct,
                                    @RequestParam String code,
                              @RequestParam String nameCategory,
                              @RequestParam String composition, @RequestParam String foto){
        Product product = productService.update(id, nameProduct, code, nameCategory, composition, foto);
        return ProductDto.toDto(product);
    }

    @GetMapping("/product/{id}")
    public ProductDto getProductById(@PathVariable int id){
        return ProductDto.toDto(productService.getById(id));
    }

    @GetMapping("/product/{code}")
    public ProductDto getProductByCode(@PathVariable String code){
        return ProductDto.toDto(productService.getByCode(code));
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteById(id);
    }
}
