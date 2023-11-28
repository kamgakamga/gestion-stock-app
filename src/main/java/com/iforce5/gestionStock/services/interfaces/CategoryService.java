package com.iforce5.gestionStock.services.interfaces;

import com.iforce5.gestionStock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto saveCategory(CategoryDto categoryDto);
    CategoryDto findCategoryById(Integer categoryDto);
    CategoryDto findByCategoryCode(String categoryCode);
    List<CategoryDto> getAllCategory();
    void deleteCategory(Integer categoryId);

}
