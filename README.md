# 🍔 Food Ordering System

A backend REST API for an Online Food Ordering platform built with Spring Boot and MySQL.

## 📚 Course
CMJD - Comprehensive Master Java Developer | Batch 112/113 | Assignment 1

## 🛠️ Tech Stack
- Spring Boot 4.0.5
- Spring Security + JWT
- Spring Data JPA
- MySQL
- Lombok

## 📦 Entities
- User (Roles: ADMIN, CUSTOMER)
- Food Item (Status: AVAILABLE, OUT_OF_STOCK)
- Category (One-to-Many with Food Item)
- Cart (One-to-One with User)
- Cart Item (Many-to-One with Cart and Food Item)
- Order (Status: PLACED, PREPARING, DELIVERED, CANCELLED)
- Order Item (Many-to-One with Order and Food Item)
- Payment (Status: PENDING, COMPLETED, FAILED)

## 🔐 Authentication
- JWT-based authentication
- User registration with custom password
- Role-based authorization (ADMIN, CUSTOMER)

## 🌐 API Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Login user |

### Food
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/food | Create food item |
| GET | /api/food | Get all food items |
| GET | /api/food/{id} | Get food item by ID |
| PUT | /api/food/{id} | Update food item |
| DELETE | /api/food/{id} | Delete food item |

### Category
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/category | Create category |
| GET | /api/category | Get all categories |
| PUT | /api/category/{id} | Update category |
| DELETE | /api/category/{id} | Delete category |

### Cart
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/cart/{userId} | Get cart |
| POST | /api/cart/{userId}/add | Add item to cart |
| DELETE | /api/cart/item/{cartItemId} | Remove item |
| DELETE | /api/cart/{userId}/clear | Clear cart |

### Order
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/order/{userId} | Place order |
| GET | /api/order/{userId} | Get orders |
| PUT | /api/order/{orderId}/status | Update status |

### Payment
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/payment/{orderId} | Make payment |
| GET | /api/payment/{orderId} | Get payment |

## ⚙️ Setup

1. Clone the repository
```bash
git clone https://github.com/Chanuli11/food-ordering-system.git
```

2. Configure MySQL in `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3307/food_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```

3. Run the application
```bash
./mvnw spring-boot:run
```

4. API runs on `http://localhost:8080`