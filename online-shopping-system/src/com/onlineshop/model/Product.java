package com.onlineshop.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/** Product details. FK -> categories, FK -> sellers. */
public class Product {
    private UUID id;
    private String sku;             // UK
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private Category category;      // FK -> categories
    private Seller seller;          // FK -> sellers
    private boolean isActive;
    private LocalDateTime createdAt;

    public Product() {
        this.id = UUID.randomUUID();
        this.price = BigDecimal.ZERO;
        this.isActive = true;
        this.createdAt = LocalDateTime.now();
    }

    public Product(String sku, String name, String description, BigDecimal price,
                   int stockQuantity, Category category, Seller seller) {
        this();
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.seller = seller;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public Seller getSeller() { return seller; }
    public void setSeller(Seller seller) { this.seller = seller; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Product{id=" + id + ", sku='" + sku + "', name='" + name + "', price=" + price
                + ", stockQuantity=" + stockQuantity
                + ", categoryId=" + (category != null ? category.getId() : null)
                + ", sellerId=" + (seller != null ? seller.getId() : null)
                + ", isActive=" + isActive + "}";
    }
}
