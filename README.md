<!--https://springboot-ecomanagement.onrender.com/swagger-ui/index.html-->
# SpringBoot EcoManagement API

## Introduction

The SpringBoot EcoManagement API is a comprehensive waste management system designed to help users properly categorize waste, provide disposal guidelines, and share recycling tips. This RESTful API serves as the backend for mobile and web applications focused on environmental sustainability and proper waste management practices.

The system enables users to access categorized waste information, get specific disposal instructions, and learn about recycling best practices through a well-structured and scalable architecture.

## Features

### Core Features
- **Waste Category Management**: Create, read, update, and delete waste categories (e.g., Plastic, Glass, Paper, Electronic)
- **Disposal Guidelines**: Manage detailed disposal instructions for each waste category
- **Recycling Tips**: Provide educational content and best practices for recycling
- **RESTful API**: Full CRUD operations for all entities
- **Data Validation**: Comprehensive input validation with proper error messages
- **Exception Handling**: Centralized error management with meaningful responses

### API Capabilities
- Retrieve all waste categories with their associated guidelines
- Get specific disposal guidelines by waste category
- Access recycling tips and educational content
- Create and update waste management information
- Delete outdated or incorrect information

## Core Functionality

### Waste Category Operations
- **GET** `/api/waste-categories` - Retrieve all waste categories
- **GET** `/api/waste-categories/{id}` - Get specific waste category
- **POST** `/api/waste-categories` - Create new waste category
- **PUT** `/api/waste-categories/{id}` - Update existing waste category
- **DELETE** `/api/waste-categories/{id}` - Remove waste category

### Disposal Guideline Operations
- **GET** `/api/disposal-guidelines` - Get all disposal guidelines
- **GET** `/api/disposal-guidelines/{id}` - Get specific guideline
- **GET** `/api/disposal-guidelines/waste-category/{wasteCategoryId}` - Get guidelines by category
- **POST** `/api/disposal-guidelines` - Create new guideline
- **PUT** `/api/disposal-guidelines/{id}` - Update existing guideline
- **DELETE** `/api/disposal-guidelines/{id}` - Remove guideline

### Recycling Tip Operations
- **GET** `/api/recycling-tips` - Retrieve all recycling tips
- **GET** `/api/recycling-tips/{id}` - Get specific recycling tip
- **POST** `/api/recycling-tips` - Create new recycling tip
- **PUT** `/api/recycling-tips/{id}` - Update existing tip
- **DELETE** `/api/recycling-tips/{id}` - Remove recycling tip

## Architecture

The application follows a layered architecture pattern with clear separation of concerns:

### Core Components
- **Entities**: JPA entities representing waste categories, disposal guidelines, and recycling tips
- **Repositories**: Data access layer handling database interactions using Spring Data JPA
- **Services**: Business logic layer implementing core functionality and data validation
- **Controllers**: Presentation layer managing REST API endpoints and HTTP requests
- **Exception Handling**: Centralized error management with custom exception classes
- **Configuration**: Swagger/OpenAPI documentation and application configuration

### Package Structure
```
com.ecoapp/
├── config/           # Configuration classes (Swagger)
├── controllers/      # REST controllers
├── entities/         # JPA entities
├── exceptions/       # Custom exceptions and global handler
├── repositories/     # Data access interfaces
└── services/         # Business logic services
```



```
┌─────────────────────────────────────────────────────────────────────────────┐
│                           SPRING BOOT APPLICATION                           │
├─────────────────────────────────────────────────────────────────────────────┤
│  Controllers    │  Services      │  Repositories  │  Entities    │  Config  │
│  • REST APIs    │  • Logic       │  • Data Access │  • JPA       │  • Swagger│
│  • Validation   │  • CRUD        │  • Queries     │  • Mapping   │  • Error  │
│  • Responses    │  • Business    │  • Database    │  • Relations │  • Beans  │
└─────────────────────────────────────────────────────────────────────────────┘
                                       │
                                       ▼
                              ┌─────────────────┐
                              │    DATABASE     │
                              │                 │
                              │ • waste_category│
                              │ • disposal_guide│
                              │ • recycling_tips│
                              └─────────────────┘
```

### Data Relationships
- **WasteCategory**: One-to-many relationship with DisposalGuideline
- **DisposalGuideline**: Many-to-one relationship with WasteCategory
- **RecyclingTip**: Independent entity for general recycling information

## Data Flow

### Request Processing Flow
1. **Client Request**: HTTP request sent to REST endpoint
2. **Controller Layer**: Receives request, validates path parameters
3. **Service Layer**: Implements business logic, validates data
4. **Repository Layer**: Performs database operations (CRUD)
5. **Database**: H2 in-memory database for data persistence
6. **Response Flow**: Data flows back through service and controller to client

### Exception Flow
1. **Exception Occurs**: At any layer (service, repository, validation)
2. **Global Handler**: Catches exceptions using `@ControllerAdvice`
3. **Response Generation**: Returns appropriate HTTP status and error message
4. **Client Response**: Standardized error format sent to client

## Technology Stack

### Backend Framework
- **Spring Boot 3.x**: Main application framework
- **Spring Web**: RESTful web services
- **Spring Data JPA**: Data persistence and repository pattern
- **Spring Boot Validation**: Input validation using Bean Validation

### Database
- **H2 Database**: In-memory database for development and testing
- **JPA/Hibernate**: Object-relational mapping

### Documentation & Testing
- **Swagger/OpenAPI 3**: API documentation and testing interface
- **JUnit 5**: Unit testing framework
- **Spring Boot Test**: Integration testing

### Build & Development
- **Maven**: Dependency management and build tool
- **Java 17+**: Programming language

## Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, VS Code)

### Installation & Setup

1. **Clone the Repository**
```bash
git clone <your-repository-url>
cd SpringBoot-EcoManagement
```

2. **Build the Project**
```bash
mvn clean install
```

3. **Run the Application**
```bash
mvn spring-boot:run
```

4. **Access the Application**
<!-- - API Base URL: `http://localhost:8080` -->
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- H2 Console: `http://localhost:8080/h2-console`

### Testing
Run the test suite:
```bash
mvn test
```

### Database Access
- **URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (empty)
<!-- 
## Project Structure
```
SpringBoot-EcoManagement/
├── src/main/java/com/ecoapp/
│   ├── config/SwaggerConfig.java
│   ├── controllers/
│   ├── entities/
│   ├── exceptions/
│   ├── repositories/
│   └── services/
├── src/main/resources/
│   └── application.properties
├── src/test/java/
├── pom.xml
└── README.md
``` -->

## Contributing
1. Fork the repository
2. Create a feature branch 
3. Commit your changes 
4. Push to the branch 
5. Open a Pull Request




