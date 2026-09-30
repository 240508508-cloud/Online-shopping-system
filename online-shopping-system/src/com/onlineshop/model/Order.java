package com.onlineshop.model;

import com.onlineshop.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** Completed / purchased order. FK -> customers, FK -> addresses (shipping & billing). */
public class Order {
    private UUID id;
    private String orderNo;             // UK
    private Customer customer;          // FK -> customers
    private Address shippingAddress;    // FK -> addresses
    private Address billingAddress;     // FK -> addresses
    private OrderStatus status;
    private List<OrderItem> items;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;

    public Order() {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.PENDING;
        this.items = new ArrayList<>();
        this.totalAmount = BigDecimal.ZERO;
        this.orderDate = LocalDateTime.now();
    }

    public Order(String orderNo, Customer customer, Address shippingAddress, Address billingAddress) {
        this();
        this.orderNo = orderNo;
        this.customer = customer;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    /** Adds an item, links it to this order and recalculates the total. */
    public void addItem(OrderItem item) {
        item.setOrder(this);
        items.add(item);
        recalculateTotal();
    }

    public void recalculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : items) {
            total = total.add(item.getSubtotal());
        }
        this.totalAmount = total;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Address getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(Address shippingAddress) { this.shippingAddress = shippingAddress; }
    public Address getBillingAddress() { return billingAddress; }
    public void setBillingAddress(Address billingAddress) { this.billingAddress = billingAddress; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; recalculateTotal(); }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    @Override
    public String toString() {
        return "Order{id=" + id + ", orderNo='" + orderNo + "', customerId="
                + (customer != null ? customer.getId() : null)
                + ", shippingAddressId=" + (shippingAddress != null ? shippingAddress.getId() : null)
                + ", billingAddressId=" + (billingAddress != null ? billingAddress.getId() : null)
                + ", status=" + status + ", itemCount=" + items.size()
                + ", totalAmount=" + totalAmount + ", orderDate=" + orderDate + "}";
    }
}
