package com.samsung.rest.dto;


import com.samsung.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private int id;

    private String name;

    private String code;

    private CategoryDto categoryDto;

    private String composition;

    private String foto;


    public static ProductDto toDto(Product product){


        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getCode(),
                CategoryDto.toDto(product.getCategory()),
                product.getComposition(),
                product.getFoto()
        );
    }
}
