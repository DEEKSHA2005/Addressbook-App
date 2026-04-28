# Address Book App (Spring Boot)

---

## Overview

The **Address Book App** is a Spring Boot REST API that manages contact details.
It demonstrates a complete backend application with CRUD operations, validation, exception handling, and MySQL database integration using a clean layered architecture.

---

## Tech Stack

* Java 17
* Spring Boot 3
* Spring Web
* Spring Data JPA
* MySQL
* Lombok
* Maven
* Postman

---

## Project Structure

```
com.bridgelabz.addressbook
│
├── controller
├── service
├── repository
├── model
├── dto
├── exception
└── AddressbookAppApplication.java
```

---

# Use Case Descriptions (UC1 – UC13)

---

## 🔹 Section 1 — Project Setup & REST API

### 🔸 UC1 — Address Book Setup

Initializes the Spring Boot project and sets up the base structure for the Address Book application.

### 🔸 UC2 — Address Book REST API

Creates REST controller and exposes basic API endpoints for handling HTTP requests.

---

## 🔹 Section 2 — Application Layers

### 🔸 UC3 — DTO & Model Creation

Defines `AddressBookDTO` and `AddressBookModel` classes for data transfer and entity representation.

### 🔸 UC4 — Service Layer Implementation

Implements business logic inside the service layer.

### 🔸 UC5 — Address Book Service Operations

Implements core operations like create, read, update, and delete in the service layer.

---

## 🔹 Section 3 — Logging & Database

### 🔸 UC6 — Lombok Setup

Uses Lombok annotations to reduce boilerplate code (getters, setters, constructors).

### 🔸 UC7 — Logging Implementation

Implements logging using Lombok (`@Slf4j`) for tracking application flow.

### 🔸 UC8 — Logging Profiles

Configures logging levels and patterns using environment-based profiles (dev, prod).

### 🔸 UC9 — Database Configuration

Integrates MySQL database using Spring Data JPA and environment-based configuration.

---

## 🔹 Section 4 — Validation & Exception Handling

### 🔸 UC10 — Input Validation

Applies validation on input fields using annotations like `@NotBlank` and `@Pattern`.

### 🔸 UC11 — Validation Exception Handling

Handles validation errors globally using `@RestControllerAdvice` and returns clean responses.

### 🔸 UC12 — Custom Exception Handling

Implements custom exception (`AddressBookException`) to handle cases like ID not found.

---

#  API Endpoints

### 🔹 Create Address

```http
POST /addressbook
```

### 🔹 Get All Addresses

```http
GET /addressbook
```

### 🔹 Get Address By ID

```http
GET /addressbook/{id}
```

### 🔹 Update Address

```http
PUT /addressbook/{id}
```

### 🔹 Delete Address

```http
DELETE /addressbook/{id}
```

---

#  Sample Outputs

### ✅ Create Success

```json
{
  "id": 1,
  "name": "Deeksha",
  "city": "Chennai"
}
```

---

### ✅ Get All

```json
[
  {
    "id": 1,
    "name": "Deeksha",
    "city": "Chennai"
  }
]
```

---
