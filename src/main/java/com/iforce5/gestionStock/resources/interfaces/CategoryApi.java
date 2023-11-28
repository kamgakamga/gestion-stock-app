package com.iforce5.gestionStock.resources.interfaces;

import com.iforce5.gestionStock.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.iforce5.gestionStock.utils.Constants.APP_ROOT;

public interface CategoryApi {
    // @Qualifier("ArticleService")
    // final public ArticleService articleService;

    // public ArticleApi(ArticleService articleService) {
    // this.articleService = articleService;
    //   }

    @PostMapping(value = APP_ROOT+"/category/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto saveCategory(@RequestBody CategoryDto categoryDto);

    @GetMapping(value =  "/category/{categoryId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findCategoryById(@PathVariable("categoryId") Integer categoryId);

    @GetMapping(value =  "/category/{codeCategory}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCategoryCode(@PathVariable("codeCategory") String codeCategory);

    @GetMapping(value =  "/category/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> getAllCategory();

    @DeleteMapping(value =  "/category/delete/{categoryId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteCategory(@PathVariable("categoryId") Integer categoryId);
}
