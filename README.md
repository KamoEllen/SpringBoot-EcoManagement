# SpringBoot-EcoManagement

Entities represent waste categories, disposal guidelines and recycling tips. Repositories act as data managers, handling data persistence. Services implement the application's logic, interacting with the repositories. Controllers manage external requests from the frontend. A global exception handler provides error management, and an H2 database provides data storage.

Workflow
🌐 Frontend App (User Device)
   |
   | HTTP Request (GET/POST/PUT/DELETE)
   v
🎛️ Controller
   |
   | Calls Service
   v
🛠️ Service Layer
   |
   | Calls Repository
   v
📚 Repository
   |
   | Database Query (CRUD Operations)
   v
💾 H2 Database (In-Memory)
   |
   | Returns Data
   v
📚 Repository
   |
   | Returns Data
   v
🛠️ Service Layer
   |
   | Returns Data
   v
🎛️ Controller
   |
   | Returns JSON Response
   v
🌐 Frontend App (User Device)

Relationships
WasteCategory should have a one-to-many relationship with DisposalGuideline and RecyclingTip.
DisposalGuideline and RecyclingTip should have a many-to-one relationship with WasteCategory.
