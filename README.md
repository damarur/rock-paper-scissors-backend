# Spring Backend Application

## Overview

This is the **backend module** of the project, built using **Spring Boot** with the integration of **Spring MVC** and **Spring Data JPA**. 
The backend serves as the RESTful API provider for the frontend application, handling business logic, data persistence, and interaction with the database.

The project is designed with a clean architecture, focusing on **scalability**, **reusability**, and **maintainability**.

---

## Project Structure

The backend project follows the **MVC (Model-View-Controller)** architectural pattern along with layered architecture:

1. **Controller Layer**:
  - Contains RESTful API endpoints for the frontend to interact with.
  - Implements lightweight validation and routing logic.

2. **Service Layer**:
  - Contains business logic and serves as the intermediary between the controller and repository layers.

3. **Repository Layer**:
  - Handles database operations using **Spring Data JPA** for ORM (Object-Relational Mapping).
  - Supports custom query methods via JPA repository interfaces.

4. **Model Layer**:
  - Contains JPA entities and domain models, representing the database structure.

---

## Technologies

### Core Technologies
- **Spring Boot**:
  - Core platform for dependency injection and RESTful API development.
- **Spring MVC**:
  - Provides REST controller functionality.
- **Spring Data JPA**:
  - Simplifies database interactions and automation of ORM mappings.
- **Lombok**:
  - Reduces boilerplate code such as getters, setters, constructors, etc.

### Additional Tools
- **Java SDK 21**:
  - The project runs on the latest features of Java.
- **Maven**:
  - Handles dependency management and builds the application.

---

## Prerequisites

To run the backend locally, ensure you have the following installed:

1. **Java Development Kit (JDK)**: Version 21 or above.
2. **Apache Maven**: Version 3.x or above.
3. **Database**: PostgreSQL/MySQL/Your Preferred Database (configured in `application.properties`).

---

## Setting up the Backend

### 1. Clone the Repository

Clone the repository and navigate to the `backend` directory:

```bash
git clone https://github.com/damarur/rock-paper-scissors-backend
cd rock-paper-scissors-backend
```

### 2. Configure the Database

Update the `src/main/resources/application.properties` file with your database connection details:

```properties
spring.datasource.url=jdbc:<your-database-url>
spring.datasource.username=<your-database-username>
spring.datasource.password=<your-database-password>
spring.jpa.hibernate.ddl-auto=update
```

**Sample for PostgreSQL:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the Application

You can build and run the application using Maven:

```bash
mvn clean install
mvn spring-boot:run
```

The backend will be running at `http://localhost:8080`.

---

## REST API Structure

You can check the current APIs accessing: `http://localhost:8080/swagger-ui/index.html`

---

## Database Setup

### Supported Databases
The application can run on any relational database supported by JPA, such as **PostgreSQL**, **MySQL**, or **H2** (in-memory for testing).

---

## Testing

### Unit Testing

The project uses **JUnit** for unit tests. Test cases are created for services, repositories, and controllers. To run tests:

```bash
mvn test
```

### Integration Testing

End-to-end testing for API endpoints is implemented using **MockMvc**, which allows testing the Controller layer without deploying the app.

---

## Building for Production

When building the project for production, you can use Maven to create an executable JAR file:

```bash
mvn clean package
```

The output JAR file will be located in the `target/` directory. You can run it with:

```bash
java -jar target/<filename>.jar
```

---

## Project Features

- **RESTful APIs** following industry best practices.
- **Entity Mapping** using JPA with clean and normalized schema.
- **Scalable Design** to extend easily with new services or resources.

---

## Contribution Guidelines

To contribute to the backend project:

1. Fork the repository.
2. Create a feature branch:
   ```bash
   git checkout -b feature/<your-feature-name>
   ```
3. Implement your feature and commit:
   ```bash
   git commit -m "Added <feature-name>"
   ```
4. Push to your repository:
   ```bash
   git push origin feature/<your-feature-name>
   ```
5. Open a pull request for review.

---

## Contact

For any questions or issues, feel free to reach out to:

- **Email:** [david.martinez.dev@gmail.com](mailto:david.martinez.dev@gmail.com)
- **GitHub:** [damarur](https://github.com/damarur)