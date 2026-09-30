package com.onlineshop.model;

import com.onlineshop.enums.PaymentMethod;
import com.onlineshop.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/** Payment information. FK -> orders. */
public class Payment {
    private UUID id;
    private Order order;                // FK -> orders
    private PaymentMethod method;
    private PaymentStatus status;
    private BigDecimal amount;
    private String transactionRef;      // UK (from payment provider)
    private LocalDateTime paidAt;

    public Payment() {
        this.id = UUID.randomUUID();
        this.status = PaymentStatus.PENDING;
        this.amount = BigDecimal.ZERO;
    }

    public Payment(Order order, PaymentMethod method, BigDecimal amount, String transactionRef) {
        this();
        this.order = order;
        this.method = method;
        this.amount = amount;
        this.transactionRef = transactionRef;
    }

    /** Marks the payment as completed and stamps the time. */
    public void complete() {
        this.status = PaymentStatus.COMPLETED;
        this.paidAt = LocalDateTime.now();
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public PaymentMethod getMethod() { return method; }
    public void setMethod(PaymentMethod method) { this.method = method; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getTransactionRef() { return transactionRef; }
    public void setTransactionRef(String transactionRef) { this.transactionRef = transactionRef; }
    public LocalDateTime getPaidAt() { return paidAt; }
    public void setPaidAt(LocalDateTime paidAt) { this.paidAt = paidAt; }

    @Override
    public String toString() {
        return "Payment{id=" + id + ", orderId=" + (order != null ? order.getId() : null)
                + ", method=" + method + ", status=" + status + ", amount=" + amount
                + ", transactionRef='" + transactionRef + "', paidAt=" + paidAt + "}";
    }
}
