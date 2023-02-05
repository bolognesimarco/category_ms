package com.mbolo.budgetapp.categories;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String shortDescription;
    private String description;

    @OneToMany(
        mappedBy = "superCategory",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Category> subCategories = new ArrayList<>();

    public void addSubCategory(Category subCategory) {
        subCategories.add(subCategory);
        subCategory.setSuperCategory(this);
    }

    public void removeSubCategory(Category subCategory) {
        subCategories.remove(subCategory);
        subCategory.setSuperCategory(null);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Category superCategory;

    public void setSuperCategory(Category superCategory) {
        this.superCategory = superCategory;
    }

    public Category getSuperCategory() {
        return this.superCategory;
    }

    protected Category(){}

    public Category(String shortDescription, String description) {
        this.shortDescription = shortDescription;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
            "Category[id=%d, shortDescription='%s', description='%s']", 
            id, 
            shortDescription, 
            description);
    }
    
}
