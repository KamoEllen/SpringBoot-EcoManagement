#### Types of Mappings:
1. **Unidirectional One-to-One Mapping**:
   - Example: One customer purchases one item.
   - The association is defined using `@OneToOne` on the customer entity.
   - Hibernate generates a foreign key in the customer table referencing the item table.
   - Customization of the foreign key column can be done using `@JoinColumn`.

2. **Bidirectional One-to-One Mapping**:
   - Both customer and item entities can reference each other.
   - The owning side (customer) contains the foreign key.
   - The reference side (item) uses `mappedBy` to indicate the association.

3. **One-to-One with Joining Table**:
   - A separate table (e.g., `customer_item`) is created to manage the relationship.
   - This table contains foreign keys from both the customer and item tables.

4. **Unidirectional One-to-Many Mapping**:
   - Example: One customer can purchase multiple items.
   - Defined using `@OneToMany` on the customer entity.
   - A joining table (`customer_item`) is created by default unless a `@JoinColumn` is specified.

5. **Bidirectional One-to-Many and Many-to-One Mapping**:
   - The "many" side (item) is the owning side and contains the foreign key.
   - The "one" side (customer) uses `mappedBy` to reference the owning side.
   - The `@JoinColumn` is used to customize the foreign key column.

6. **Many-to-Many Mapping**:
   - Example: Many customers can purchase many items.
   - A joining table (`customer_item`) is automatically created.
   - Customization of the joining table can be done using `@JoinTable`.
   - In bidirectional many-to-many mappings, either side can be the owning side.

#### Key Concepts:
- **Owning Side**: The entity that contains the foreign key and manages the relationship.
- **Reference Side**: The entity that uses `mappedBy` to reference the owning side.
- **Cascade Types**: Used to propagate operations (e.g., save, delete) from one entity to another.
- **Joining Table**: A table created to manage many-to-many or one-to-one relationships, containing foreign keys from both related tables.

#### Practical Implementation:
- **Customer and Item Entities**:
  - Customer entity contains a reference to the item(s) using `@OneToOne`, `@OneToMany`, or `@ManyToMany`.
  - Item entity may contain a reference back to the customer using `mappedBy` in bidirectional mappings.
- **Repositories**:
  - Custom repositories extend `JpaRepository` to provide custom methods for saving and retrieving data.
- **Cascade Types**:
  - `CascadeType.ALL` ensures that operations on the customer entity also affect the associated item(s).

#### Example Scenarios:
1. **Unidirectional One-to-One**:
   - Customer entity has a `@OneToOne` relationship with the item entity.
   - Hibernate generates a foreign key in the customer table.

2. **Bidirectional One-to-One**:
   - Both customer and item entities reference each other.
   - The customer entity uses `@JoinColumn`, while the item entity uses `mappedBy`.

3. **One-to-Many with Joining Table**:
   - A joining table is created to manage the relationship between customer and items.
   - The joining table contains foreign keys from both tables.

4. **Many-to-Many**:
   - A joining table is created to manage the many-to-many relationship.
   - Customization of the joining table is possible using `@JoinTable`.

#### Customization:
- **Foreign Key Column**: Use `@JoinColumn` to customize the foreign key column name.
- **Joining Table**: Use `@JoinTable` to customize the joining table and its columns.

#### Summary:
- JPA entity mappings allow for flexible and efficient management of relationships between entities.
- Understanding the owning side, reference side, and cascade types is crucial for implementing these mappings correctly.
- Customization options like `@JoinColumn` and `@JoinTable` provide control over how relationships are managed in the database.

---

### Key Definitions:

1. **Mapping**:
   - Mapping refers to the way relationships between different entities (tables) in a database are defined and managed in an application. It specifies how one entity relates to another, such as one-to-one, one-to-many, or many-to-many relationships. Mappings are typically defined using annotations like `@OneToOne`, `@OneToMany`, `@ManyToOne`, and `@ManyToMany` in JPA.

2. **Entity**:
   - An entity is a lightweight, persistent domain object in Java that represents a table in a relational database. Each instance of an entity corresponds to a row in the table. Entities are typically annotated with `@Entity` and contain fields that map to columns in the table. For example, a `Customer` entity might represent a `customer` table in the database.

3. **JPA (Java Persistence API)**:
   - JPA is a Java specification for accessing, persisting, and managing data between Java objects and a relational database. It provides a set of interfaces and annotations to map Java objects to database tables and vice versa. JPA simplifies database operations by allowing developers to work with objects rather than writing complex SQL queries.

4. **Hibernate**:
   - Hibernate is an open-source Object-Relational Mapping (ORM) framework for Java. It implements the JPA specification and provides additional features for mapping Java objects to database tables. Hibernate handles the conversion of Java objects to database rows and vice versa, making it easier to perform CRUD (Create, Read, Update, Delete) operations without writing SQL queries. It also supports advanced features like caching, lazy loading, and transaction management.

---

### Nb:
- **Mapping** defines how entities relate to each other in the database.
- **Entity** is a Java object that represents a table in the database.
- **JPA** is a specification for managing relational data in Java applications.
- **Hibernate** is a popular ORM framework that implements JPA and simplifies database interactions.
