package com.onlineshop.model;

import java.math.BigDecimal;
import java.util.UUID;

/** Product included in an order. FK -> orders, FK -> products. */
public class OrderItem {
    private UUID id;
    private Order order;            // FK -> orders
    private Product product;        // FK -> products
    private int quantity;
    private BigDecimal unitPrice;   // price at purchase time

    public OrderItem() {
        this.id = UUID.randomUUID();
        this.quantity = 1;
        this.unitPrice = BigDecimal.ZERO;
    }

    public OrderItem(Product product, int quantity, BigDecimal unitPrice) {
        this();
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    /** Creates an order item from a cart item (used at checkout). */
    public static OrderItem fromCartItem(CartItem cartItem) {
        return new OrderItem(cartItem.getProduct(), cartItem.getQuantity(), cartItem.getUnitPrice());
    }

    public BigDecimal getSubtotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }

    @Override
    public String toString() {
        return "OrderItem{id=" + id + ", orderId=" + (order != null ? order.getId() : null)
                + ", product='" + (product != null ? product.getName() : null) + "', quantity="
                + quantity + ", unitPrice=" + unitPrice + ", subtotal=" + getSubtotal() + "}";
    }
}
