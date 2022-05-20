package com.samsung.rest.dto;

import com.samsung.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private int id;

    private String name;


    public static CategoryDto toDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }

    public static Category toDomainObject(CategoryDto categoryDto){
        return new Category(
                categoryDto.getId(),
                categoryDto.getName()
        );
    }
}
