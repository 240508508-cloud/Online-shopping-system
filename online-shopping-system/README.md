# Online Shopping System – Class Design

**Language used: Java (JDK 11+)**

Object-oriented class design for an online shopping system, modelled after the
conventions of the reference university schema (UUID primary keys, `UK`/`FK` markers,
enums, `is_active`, `created_at`, etc.).

## Structure
```
src/com/onlineshop/
├── Main.java
├── enums/   Gender, CustomerStatus, AddressType, CartStatus, OrderStatus, PaymentMethod, PaymentStatus
└── model/   Customer, Product, Category, ShoppingCart, CartItem, Order, OrderItem, Payment, Address, Seller
```

## Relationships (FK references)
| Class | FK / relation |
|---|---|
| Address | `customer` -> Customer |
| Category | `parentCategory` -> Category (self reference) |
| Product | `category` -> Category, `seller` -> Seller |
| ShoppingCart | `customer` -> Customer; has many `CartItem` |
| CartItem | `cart` -> ShoppingCart, `product` -> Product |
| Order | `customer` -> Customer, `shippingAddress` / `billingAddress` -> Address; has many `OrderItem` |
| OrderItem | `order` -> Order, `product` -> Product |
| Payment | `order` -> Order |

Each class has private fields, getters/setters, a no-arg and a parameterized constructor,
and an overridden `toString()` (which prints FK ids instead of whole objects to avoid infinite recursion).

## Build & Run
```bash
mkdir -p out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out com.onlineshop.Main
```
