package com.onlineshop;

import com.onlineshop.enums.AddressType;
import com.onlineshop.enums.Gender;
import com.onlineshop.enums.OrderStatus;
import com.onlineshop.enums.PaymentMethod;
import com.onlineshop.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Language used: Java. Entry point of the Online Shopping System. */
public class Main {
    public static void main(String[] args) {

        // ===== REQUIRED PART: register customers and print them =====
        List<Customer> customers = new ArrayList<>();

        customers.add(new Customer("C-0001", "Ayse", "Yilmaz", LocalDate.of(2000, 5, 14),
                Gender.FEMALE, "ayse.yilmaz@example.com", "+90 555 111 22 33", "hash_ayse"));
        customers.add(new Customer("C-0002", "Mehmet", "Demir", LocalDate.of(1998, 11, 3),
                Gender.MALE, "mehmet.demir@example.com", "+90 555 444 55 66", "hash_mehmet"));

        System.out.println("=== Registered Customers ===");
        for (Customer c : customers) {
            System.out.println(c);
        }

        // ===== BONUS: shows how all the other classes work together =====
        Customer customer = customers.get(0);

        Seller seller = new Seller("S-001", "TechStore", "1234567890", "info@techstore.com", "+90 212 000 00 00");
        Category electronics = new Category("ELEC", "Electronics", "Electronic devices", null);
        Category laptops = new Category("LAPT", "Laptops", "Notebook computers", electronics);

        Product laptop = new Product("SKU-1001", "UltraBook 14", "14-inch laptop",
                new BigDecimal("24999.90"), 25, laptops, seller);
        Product mouse = new Product("SKU-2001", "Wireless Mouse", "Ergonomic mouse",
                new BigDecimal("349.50"), 100, electronics, seller);

        Address home = new Address(customer, AddressType.SHIPPING, "Home",
                "Ataturk Cad. No:12", "Istanbul", "Kadikoy", "34700", "Turkey");
        home.setDefault(true);

        ShoppingCart cart = new ShoppingCart(customer);
        cart.addItem(new CartItem(laptop, 1));
        cart.addItem(new CartItem(mouse, 2));

        Order order = new Order("ORD-0001", customer, home, home);
        for (CartItem ci : cart.getItems()) {
            order.addItem(OrderItem.fromCartItem(ci));
        }

        Payment payment = new Payment(order, PaymentMethod.CREDIT_CARD, order.getTotalAmount(), "TXN-987654");
        payment.complete();
        order.setStatus(OrderStatus.PAID);

        System.out.println("\n=== Demo: Full Purchase Flow ===");
        System.out.println(seller);
        System.out.println(electronics);
        System.out.println(laptops);
        System.out.println(laptop);
        System.out.println(mouse);
        System.out.println(home);
        System.out.println(cart);
        cart.getItems().forEach(System.out::println);
        System.out.println(order);
        order.getItems().forEach(System.out::println);
        System.out.println(payment);
    }
}
