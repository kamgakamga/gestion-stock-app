package com.iforce5.gestionStock.services.implementations;

import com.iforce5.gestionStock.dto.CategoryDto;
import com.iforce5.gestionStock.exceptions.EntityNotFoundException;
import com.iforce5.gestionStock.exceptions.enums.ErrosCodes;
import com.iforce5.gestionStock.models.Category;
import com.iforce5.gestionStock.repositories.CategoryRepository;
import com.iforce5.gestionStock.services.interfaces.CategoryService;
import com.iforce5.gestionStock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImplementation  implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category categoryToSave = null;
        Category savedCategory = null;

        List<String> errors = CategoryValidator.validate(categoryDto);
        if (!errors.isEmpty()){
            log.error("Category not found {}", categoryDto);
            return  null;
        }
        // Cas de la modification de a categorie
        if(Objects.nonNull(categoryDto.getId()) && categoryDto.getId()  > 0  ){
            Category categoryToUpdate = categoryRepository.findById(categoryDto.getId()).orElseThrow(
                    ()-> new EntityNotFoundException("Aucune category trouvé avec l'id: "+categoryDto.getId(), ErrosCodes.CATEGORY_NOT_FOUND));
            log.info("La categorie a modifier est {} ", categoryToUpdate);

            categoryToSave = CategoryDto.buildUpdateCategory(categoryDto, categoryToUpdate );
        }else {
            categoryToSave = CategoryDto.buildCategoryFromCategoryDto(categoryDto);
        }
        savedCategory = categoryRepository.save(categoryToSave);
        log.info("La categorie sauvegardé avec success {} ", savedCategory);
        return CategoryDto.fromEntity(savedCategory) ;
    }

    @Override
    public CategoryDto findCategoryById(Integer categoryId) {
        if(Objects.isNull(categoryId)){
            log.error(" Category ID is null");
            return  null;
        }
        Category category = categoryRepository.findById(categoryId).orElseThrow( ()-> new EntityNotFoundException("Aucune category trouvé avec l'id ="+categoryId, ErrosCodes.CATEGORY_NOT_FOUND));
        return CategoryDto.fromEntity(category) ;
    }

    @Override
    public CategoryDto findByCategoryCode(String categoryCode) {
        if(!StringUtils.hasLength(categoryCode) ){
            log.error(" Category Code is null");
            return  null;
        }
        Category category = categoryRepository.findCategoryByCode(categoryCode).orElseThrow(
                ()-> new EntityNotFoundException("Aucune category trouvé avec le code ="+categoryCode, ErrosCodes.CATEGORY_NOT_FOUND));
        return CategoryDto.fromEntity(category) ;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        if(Objects.isNull(categoryId)){
            log.error(" Category ID is null");
            return;
        }
        categoryRepository.deleteById(categoryId);
    }
}
