package com.onlineshop.model;

import java.util.UUID;

/** Product category. parentCategory is a self-reference (FK -> categories), like course prerequisites. */
public class Category {
    private UUID id;
    private String code;            // UK
    private String name;
    private String description;
    private Category parentCategory; // FK -> categories (nullable)
    private boolean isActive;

    public Category() {
        this.id = UUID.randomUUID();
        this.isActive = true;
    }

    public Category(String code, String name, String description, Category parentCategory) {
        this();
        this.code = code;
        this.name = name;
        this.description = description;
        this.parentCategory = parentCategory;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Category getParentCategory() { return parentCategory; }
    public void setParentCategory(Category parentCategory) { this.parentCategory = parentCategory; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    @Override
    public String toString() {
        return "Category{id=" + id + ", code='" + code + "', name='" + name + "', description='"
                + description + "', parentCategoryId="
                + (parentCategory != null ? parentCategory.getId() : null) + ", isActive=" + isActive + "}";
    }
}
