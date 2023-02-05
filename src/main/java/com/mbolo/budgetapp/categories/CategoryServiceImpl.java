package com.mbolo.budgetapp.categories;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> fetchCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category categoryDB = categoryRepository.findById(categoryId).get();
        if(Objects.nonNull(category.getShortDescription()) && !"".equalsIgnoreCase(category.getShortDescription())){
            categoryDB.setShortDescription(category.getShortDescription());
        }
        if(Objects.nonNull(category.getDescription()) && !"".equalsIgnoreCase(category.getDescription())){
            categoryDB.setDescription(category.getDescription());
        }
        return categoryRepository.save(categoryDB);
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);        
    }
    
}
