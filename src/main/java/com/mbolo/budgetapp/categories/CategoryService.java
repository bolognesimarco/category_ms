package com.mbolo.budgetapp.categories;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> fetchCategoryList();
    Category updateCategory(Category category, Long categoryId);
    void deleteCategoryById(Long ctegoryId);
}
