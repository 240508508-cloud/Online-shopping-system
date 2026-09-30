package com.onlineshop.model;

import com.onlineshop.enums.CartStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** Customer's cart. FK -> customers. One cart has many CartItems. */
public class ShoppingCart {
    private UUID id;
    private Customer customer;          // FK -> customers
    private CartStatus status;
    private List<CartItem> items;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ShoppingCart() {
        this.id = UUID.randomUUID();
        this.status = CartStatus.ACTIVE;
        this.items = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    public ShoppingCart(Customer customer) {
        this();
        this.customer = customer;
    }

    /** Adds an item and links it back to this cart. */
    public void addItem(CartItem item) {
        item.setCart(this);
        items.add(item);
        this.updatedAt = LocalDateTime.now();
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : items) {
            total = total.add(item.getSubtotal());
        }
        return total;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public CartStatus getStatus() { return status; }
    public void setStatus(CartStatus status) { this.status = status; }
    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "ShoppingCart{id=" + id + ", customerId=" + (customer != null ? customer.getId() : null)
                + ", status=" + status + ", itemCount=" + items.size() + ", total=" + getTotal()
                + ", createdAt=" + createdAt + "}";
    }
}
