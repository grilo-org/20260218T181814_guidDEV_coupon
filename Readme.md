# Coupon API

REST API for managing discount coupons, built with **Java 21** and **Spring Boot**, following **Clean Architecture** and **Domain-Driven Design (DDD)** principles.

---

## 🚀 Technologies

* Java 21
* Spring Boot 3
* Spring Data JPA
* H2 In-Memory Database
* OpenAPI / Swagger
* Docker & Docker Compose
* JUnit 5 + Mockito

---

## 🏗️ Architecture

The project follows **Clean Architecture**, organized into:

* **domain** → business rules, entities, and domain exceptions
* **application** → use cases (business orchestration)
* **infra** → JPA persistence and repository implementations
* **interfaces** → REST controllers and global exception handling

This structure ensures:

* separation of concerns
* testability
* independence from frameworks in the domain layer

---

## ▶️ Running Locally

### 1. Build the project

```bash
mvn clean package
```

### 2. Run the application

```bash
mvn spring-boot:run
```

### 3. Access Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🐳 Running with Docker

```bash
mvn clean package
docker compose up --build
```

API will be available at:

```
http://localhost:8080
```

> ⚠️ **Docker Note**
> The repository includes a fully functional `Dockerfile` and `docker-compose.yml`.
> If Docker is not available in the local environment, the application can still be executed normally using:
>
> ```bash
> mvn spring-boot:run
> ```

---

## 🧪 Tests

Run tests with:

```bash
mvn test
```

Approximate coverage: **85%** class coverage (it's possible see results using "Run  tests in Java with Coverage")

---

## 📌 Business Rules

### Create Coupon

* Coupon code must be **alphanumeric with 6 characters** (after sanitization).
* **Description is required**.
* Minimum discount value is **0.5** (no maximum).
* Expiration date **cannot be in the past**.
* Coupon **may be created as published**.

### Delete Coupon

* Uses **soft delete** (record is not physically removed).
* Cannot delete the same coupon twice.
* Returns **404** when coupon is not found.

### Get Coupons

* Deleted coupons are **not returned** in listings.
* Accessing a deleted or nonexistent coupon by ID returns **404**.

---

## 📚 API Documentation

Interactive documentation is available via **Swagger UI**:

```
/swagger-ui/index.html
```

It provides:

* endpoint descriptions
* request/response schemas
* HTTP status codes
* error contracts

---

## 👨‍💻 Author

**Pedro Franco Guidolin**
