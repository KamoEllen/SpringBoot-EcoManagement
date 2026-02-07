<!--https://springboot-ecomanagement.onrender.com/swagger-ui/index.html-->

<!--
**Owner:** KamoEllen
**Category:** Backend
**Repo:** [RBAC](https://github.com/KamoEllen/SpringBoot-EcoManagement)
**Status:** Completed

---

-->
## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)

   * [Waste Category Management](#waste-category-management)
   * [Disposal Guidelines](#disposal-guidelines)
   * [Recycling Tips](#recycling-tips)
3. [Core Functionality](#core-functionality)
4. [Architecture](#architecture)

   * [Layered Architecture](#layered-architecture)
   * [Package Structure](#package-structure)
   * [Data Relationships](#data-relationships)
   * [Data Flow](#data-flow)
5. [Technology Stack](#technology-stack)
6. [Quick Start](#quick-start)

   * [Prerequisites](#prerequisites)
   * [Installation](#installation)
   * [Running the Application](#running-the-application)
   * [Accessing the API](#accessing-the-api)
   * [Running Tests](#running-tests)
7. [Contributing](#contributing)

---

## Introduction

The **SpringBoot EcoManagement API** is a backend service for managing waste categorization, disposal guidelines, and recycling tips. This RESTful API supports web and mobile applications aimed at promoting environmental sustainability and proper waste management practices.

---

## Features

### Waste Category Management

* CRUD operations for waste categories (Plastic, Glass, Paper, Electronics, etc.)
* Input validation and error handling for all operations

### Disposal Guidelines

* CRUD operations for disposal instructions per waste category
* Retrieve guidelines by category ID

### Recycling Tips

* CRUD operations for recycling tips and educational content
* Centralized access to all tips for clients

---

## Core Functionality

### Waste Category Endpoints

| Method | Endpoint                     | Description                   |
| ------ | ---------------------------- | ----------------------------- |
| GET    | `/api/waste-categories`      | Retrieve all waste categories |
| GET    | `/api/waste-categories/{id}` | Retrieve a specific category  |
| POST   | `/api/waste-categories`      | Create a new category         |
| PUT    | `/api/waste-categories/{id}` | Update a category             |
| DELETE | `/api/waste-categories/{id}` | Delete a category             |

### Disposal Guideline Endpoints

| Method | Endpoint                                                    | Description                   |
| ------ | ----------------------------------------------------------- | ----------------------------- |
| GET    | `/api/disposal-guidelines`                                  | Retrieve all guidelines       |
| GET    | `/api/disposal-guidelines/{id}`                             | Retrieve a specific guideline |
| GET    | `/api/disposal-guidelines/waste-category/{wasteCategoryId}` | Guidelines by category        |
| POST   | `/api/disposal-guidelines`                                  | Create a guideline            |
| PUT    | `/api/disposal-guidelines/{id}`                             | Update a guideline            |
| DELETE | `/api/disposal-guidelines/{id}`                             | Delete a guideline            |

### Recycling Tip Endpoints

| Method | Endpoint                   | Description                 |
| ------ | -------------------------- | --------------------------- |
| GET    | `/api/recycling-tips`      | Retrieve all recycling tips |
| GET    | `/api/recycling-tips/{id}` | Retrieve a specific tip     |
| POST   | `/api/recycling-tips`      | Create a tip                |
| PUT    | `/api/recycling-tips/{id}` | Update a tip                |
| DELETE | `/api/recycling-tips/{id}` | Delete a tip                |

---

## Architecture

### Layered Architecture

The application uses a **layered architecture** with clear separation of concerns:

* **Controllers**: Handle REST API requests, validation, and response formatting
* **Services**: Implement business logic, validations, and orchestration
* **Repositories**: Data access via Spring Data JPA
* **Entities**: JPA entities representing database tables
* **Exceptions**: Centralized error handling using `@ControllerAdvice`
* **Configuration**: Swagger/OpenAPI setup and application configuration

### Package Structure

```
com.ecoapp/
├── config/        # Swagger and application configs
├── controllers/   # REST API controllers
├── entities/      # JPA entities
├── exceptions/    # Custom exceptions & global handler
├── repositories/  # Data access interfaces
└── services/      # Business logic services
```

### Data Relationships

* **WasteCategory** → One-to-many with **DisposalGuideline**
* **DisposalGuideline** → Many-to-one with **WasteCategory**
* **RecyclingTip** → Independent entity

### Data Flow

1. Client sends HTTP request → **Controller**
2. Controller validates input → calls **Service Layer**
3. Service layer executes business logic → **Repository Layer**
4. Repository interacts with **H2 database**
5. Response returned to client

### Exception Handling Flow

* Exceptions at any layer are caught by a global handler
* Returns standardized HTTP status codes and messages

---

## Technology Stack

**Backend Framework**

* Spring Boot 3.x
* Spring Web (REST)
* Spring Data JPA
* Spring Boot Validation

**Database**

* H2 (in-memory for development)
* JPA/Hibernate

**Documentation & Testing**

* Swagger/OpenAPI 3
* JUnit 5 & Spring Boot Test

**Build & Development**

* Maven
* Java 17+

---

## Quick Start

### Prerequisites

* Java 17+
* Maven 3.6+
* IDE (IntelliJ, Eclipse, VS Code)

### Installation

```bash
git clone <repository-url>
cd SpringBoot-EcoManagement
mvn clean install
```

### Running the Application

```bash
mvn spring-boot:run
```

### Accessing the API

* Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

  * URL: `jdbc:h2:mem:testdb`
  * Username: `sa`
  * Password: *(empty)*

### Running Tests

```bash
mvn test
```

---

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to your branch
5. Open a Pull Request
