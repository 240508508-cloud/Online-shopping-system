package com.onlineshop.model;

import java.time.LocalDateTime;
import java.util.UUID;

/** Seller / store information. */
public class Seller {
    private UUID id;
    private String code;        // UK
    private String storeName;
    private String taxNumber;
    private String email;
    private String phone;
    private double rating;
    private boolean isActive;
    private LocalDateTime createdAt;

    public Seller() {
        this.id = UUID.randomUUID();
        this.isActive = true;
        this.createdAt = LocalDateTime.now();
    }

    public Seller(String code, String storeName, String taxNumber, String email, String phone) {
        this();
        this.code = code;
        this.storeName = storeName;
        this.taxNumber = taxNumber;
        this.email = email;
        this.phone = phone;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }
    public String getTaxNumber() { return taxNumber; }
    public void setTaxNumber(String taxNumber) { this.taxNumber = taxNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Seller{id=" + id + ", code='" + code + "', storeName='" + storeName
                + "', taxNumber='" + taxNumber + "', email='" + email + "', phone='" + phone
                + "', rating=" + rating + ", isActive=" + isActive + "}";
    }
}
