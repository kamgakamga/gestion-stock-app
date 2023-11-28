package com.iforce5.gestionStock.resources.implementations;

import com.iforce5.gestionStock.dto.CategoryDto;
import com.iforce5.gestionStock.resources.interfaces.CategoryApi;
import com.iforce5.gestionStock.services.interfaces.CategoryService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        return categoryService.saveCategory(categoryDto);
    }

    @Override
    public CategoryDto findCategoryById(Integer categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

    @Override
    public CategoryDto findByCategoryCode(String codeCategory) {
        return categoryService.findByCategoryCode(codeCategory);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
