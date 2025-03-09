<!--Post-Get-Put-Delete-->
# SpringBoot-EcoManagement

## Overview
SpringBoot-EcoManagement is a sustainable waste management application built with Spring Boot. 

## Assessment Background
This project was developed as part of the Enviro365 Graduate Software Developer Assessment.

The application is deployed on Render:
<!--
API Base URL: https://springboot-ecomanagement.onrender.com/api
-->
Swagger UI: https://springboot-ecomanagement.onrender.com/swagger-ui.html

H2 Console: https://springboot-ecomanagement.onrender.com/h2-console 

## Architecture

### Core Components
- **Entities**: Represent waste categories, disposal guidelines, and recycling tips
- **Repositories**: Handle data persistence and database interactions
- **Services**: Implement business logic and mediate between repositories and controllers
- **Controllers**: Manage external REST API requests from the mobile application
- **Global Exception Handler**: Provide standardized error management
- **H2 Database**: In-memory database for development and testing

### Data Relationships
- **WasteCategory**: Has a one-to-many relationship with DisposalGuideline and RecyclingTip
- **DisposalGuideline**: Has a many-to-one relationship with WasteCategory
- **RecyclingTip**: Has a many-to-one relationship with WasteCategory
<!-- betterrr :) -->
## Request Flow Diagram
- Client sends an HTTP request.
- Controller receives the request and calls the appropriate service.
- Service contains the business logic and interacts with the repository.
- Repository performs CRUD operations on the database.
- The response flows back through the service and controller to the client.

<!--
## Request Flow Diagram

```
🌐 Frontend Application (User Device)
   │
   │ HTTP Request (GET/POST/PUT/DELETE)
   ▼
🎛️ Controller
   │
   │ Calls Service
   ▼
🛠️ Service Layer
   │
   │ Calls Repository
   ▼
📚 Repository
   │
   │ Database Query (CRUD Operations)
   ▼
💾 H2 Database (In-Memory)
   │
   │ Returns Data
   ▼
📚 Repository
   │
   │ Returns Data
   ▼
🛠️ Service Layer
   │
   │ Returns Data
   ▼
🎛️ Controller
   │
   │ Returns JSON Response
   ▼
🌐 Frontend Application (User Device)
```
-->

## Technology Stack
- **Backend**: Spring Boot, Spring Data JPA
- **Database**: H2 (In-Memory)
- <!--**API Documentation**: SpringDocs OpenAPI -->

### Package Structure
All code is written in the package:
```
com.enviro.assessment.grad001.kamoellen
```

### Technical Specifications
- Each entity has a primary key called "id"
- Data is stored in an H2 in-memory database
- REST endpoints return JSON-formatted responses
- Input validation is implemented using Spring Boot validation annotations

  
## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application
1. Clone the repository
   ```bash
   git clone https://github.com/kamoellen/SpringBoot-EcoManagement.git
   ```

2. Navigate to the project directory
   ```bash
   cd SpringBoot-EcoManagement
   ```

3. Build the project
   ```bash
   mvn clean install
   ```

4. Run the application
   ```bash
   mvn spring-boot:run
   ```

5. Access the application
   - REST API: http://localhost:8080/api
   - H2 Console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:enviro365db)
