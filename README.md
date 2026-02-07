<!--https://springboot-ecomanagement.onrender.com/swagger-ui/index.html-->
## Introduction

The **SpringBoot EcoManagement API** is a comprehensive waste management system designed to help users categorize waste, provide disposal guidelines, and share recycling tips. This RESTful API serves as the backend for web and mobile applications focused on environmental sustainability and proper waste management practices.

Users can access categorized waste information, retrieve disposal instructions, and explore recycling best practices via a scalable and well-structured backend.

---

## Features

### Core Features

* **Waste Category Management**: CRUD operations for waste categories (Plastic, Glass, Paper, Electronics, etc.)
* **Disposal Guidelines**: Manage detailed instructions for proper waste disposal
* **Recycling Tips**: Provide educational content and best practices
* **RESTful API**: Complete CRUD support for all entities
* **Data Validation**: Comprehensive input validation with meaningful error messages
* **Exception Handling**: Centralized error management

### API Capabilities

* Retrieve all waste categories and associated guidelines
* Get specific disposal guidelines by waste category
* Access recycling tips
* Create, update, and delete waste management data

---

## Core Functionality

### Waste Category Endpoints

| Method | Endpoint                     | Description              |
| ------ | ---------------------------- | ------------------------ |
| GET    | `/api/waste-categories`      | Retrieve all categories  |
| GET    | `/api/waste-categories/{id}` | Get a specific category  |
| POST   | `/api/waste-categories`      | Create new category      |
| PUT    | `/api/waste-categories/{id}` | Update existing category |
| DELETE | `/api/waste-categories/{id}` | Remove a category        |

### Disposal Guideline Endpoints

| Method | Endpoint                                                    | Description              |
| ------ | ----------------------------------------------------------- | ------------------------ |
| GET    | `/api/disposal-guidelines`                                  | Get all guidelines       |
| GET    | `/api/disposal-guidelines/{id}`                             | Get a specific guideline |
| GET    | `/api/disposal-guidelines/waste-category/{wasteCategoryId}` | Guidelines by category   |
| POST   | `/api/disposal-guidelines`                                  | Create new guideline     |
| PUT    | `/api/disposal-guidelines/{id}`                             | Update guideline         |
| DELETE | `/api/disposal-guidelines/{id}`                             | Remove guideline         |

### Recycling Tip Endpoints

| Method | Endpoint                   | Description        |
| ------ | -------------------------- | ------------------ |
| GET    | `/api/recycling-tips`      | Retrieve all tips  |
| GET    | `/api/recycling-tips/{id}` | Get a specific tip |
| POST   | `/api/recycling-tips`      | Create new tip     |
| PUT    | `/api/recycling-tips/{id}` | Update tip         |
| DELETE | `/api/recycling-tips/{id}` | Remove tip         |

---

## Architecture

### Layered Structure

```
Controllers   → Handle REST API requests and validation
Services      → Business logic, data validation, CRUD operations
Repositories  → Data access using Spring Data JPA
Entities      → JPA entities for WasteCategory, DisposalGuideline, RecyclingTip
Config        → Swagger/OpenAPI docs, application config
Exceptions    → Centralized error handling
```

### Package Structure

```
com.ecoapp/
├── config/          # Swagger and application configurations
├── controllers/     # REST controllers
├── entities/        # JPA entities
├── exceptions/      # Custom exceptions & global handler
├── repositories/    # Data access interfaces
└── services/        # Business logic services
```

### Data Relationships

* **WasteCategory** → One-to-many with **DisposalGuideline**
* **DisposalGuideline** → Many-to-one with **WasteCategory**
* **RecyclingTip** → Independent entity for general tips

### Data Flow

1. Client sends HTTP request → Controller
2. Controller validates → Service Layer
3. Service Layer applies business logic → Repository
4. Repository interacts with **H2 database** → Response returned back

### Exception Flow

1. Exception occurs → Service or Repository layer
2. **Global Handler (@ControllerAdvice)** catches it
3. Returns standardized HTTP error response

---

## Technology Stack

**Backend Framework**

* Spring Boot 3.x
* Spring Web (REST)
* Spring Data JPA
* Spring Boot Validation

**Database**

* H2 (in-memory for development/testing)
* JPA/Hibernate

**Documentation & Testing**

* Swagger/OpenAPI 3
* JUnit 5
* Spring Boot Test

**Build & Development**

* Maven
* Java 17+

---

## Quick Start

### Prerequisites

* Java 17+
* Maven 3.6+
* IDE (IntelliJ, Eclipse, VS Code)

### Installation & Setup

```bash
# Clone repository
git clone <your-repository-url>
cd SpringBoot-EcoManagement

# Build project
mvn clean install

# Run application
mvn spring-boot:run
```

### Access the Application

* **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* **H2 Console**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

**Database Access**

* URL: `jdbc:h2:mem:testdb`
* Username: `sa`
* Password: *(empty)*

### Run Tests

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
