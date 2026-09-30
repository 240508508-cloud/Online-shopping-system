package com.onlineshop.model;

import java.math.BigDecimal;
import java.util.UUID;

/** Product + quantity inside a cart. FK -> shopping_carts, FK -> products (like PROGRAM_COURSES). */
public class CartItem {
    private UUID id;
    private ShoppingCart cart;      // FK -> shopping_carts
    private Product product;        // FK -> products
    private int quantity;
    private BigDecimal unitPrice;   // price snapshot when added

    public CartItem() {
        this.id = UUID.randomUUID();
        this.quantity = 1;
        this.unitPrice = BigDecimal.ZERO;
    }

    public CartItem(Product product, int quantity) {
        this();
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = product.getPrice();
    }

    public BigDecimal getSubtotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public ShoppingCart getCart() { return cart; }
    public void setCart(ShoppingCart cart) { this.cart = cart; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }

    @Override
    public String toString() {
        return "CartItem{id=" + id + ", cartId=" + (cart != null ? cart.getId() : null)
                + ", product='" + (product != null ? product.getName() : null) + "', quantity="
                + quantity + ", unitPrice=" + unitPrice + ", subtotal=" + getSubtotal() + "}";
    }
}
