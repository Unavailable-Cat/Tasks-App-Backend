# Tasks App Backend

A RESTful backend for a full-stack Task Management application built with **Java and Spring Boot**. The application provides APIs for creating, retrieving, updating, and deleting tasks, with data persisted in a MySQL database.

## 🚀 Features

* Create new tasks
* Retrieve all tasks
* Retrieve a task by ID
* Update existing tasks
* Delete tasks
* RESTful API architecture
* DTO-based request and response handling
* Service and Repository layer separation
* MySQL database integration
* CORS configuration for frontend integration
* Environment-based database configuration
* Docker-ready deployment

## 🛠️ Tech Stack

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Maven**
* **Docker**
* **Git & GitHub**

## 📁 Project Structure

```text
src/
├── main/
│   ├── java/com/backend/tasks/
│   │   ├── Config/
│   │   │   └── CorsConfig.java
│   │   ├── Controller/
│   │   │   └── TaskController.java
│   │   ├── DTO/
│   │   │   ├── TaskRequestDTO.java
│   │   │   └── TaskResponseDTO.java
│   │   ├── Model/
│   │   │   └── Task.java
│   │   ├── Repository/
│   │   │   └── TaskRepository.java
│   │   ├── Service/
│   │   │   └── TaskService.java
│   │   └── TasksApplication.java
│   └── resources/
│       └── application.yaml
└── test/
    └── java/com/backend/tasks/
        └── TasksApplicationTests.java
```

## 🔌 API Endpoints

| Method   | Endpoint      | Description             |
| -------- | ------------- | ----------------------- |
| `GET`    | `/tasks`      | Get all tasks           |
| `GET`    | `/tasks/{id}` | Get a task by ID        |
| `POST`   | `/tasks`      | Create a new task       |
| `PUT`    | `/tasks/{id}` | Update an existing task |
| `DELETE` | `/tasks/{id}` | Delete a task           |

> The exact request/response structure can be explored through the API documentation if Swagger/OpenAPI is enabled in the project.

## ⚙️ Configuration

The application uses environment variables for database configuration so that credentials are not stored in the source code.

Example:

```yaml
spring:
  datasource:
    url: ${DATASOURCE_URL}
    username: ${DATASOURCE_USERNAME}
    password: ${DATASOURCE_PASSWORD}
    driver-class-name: ${DATASOURCE_DRIVER}
```

### Required Environment Variables

```text
DATASOURCE_URL
DATASOURCE_USERNAME
DATASOURCE_PASSWORD
DATASOURCE_DRIVER
```

For local development, configure these variables with your local MySQL database credentials.

**Do not commit database passwords, API keys, or other secrets to the repository.**

## ▶️ Running Locally

### Prerequisites

Make sure you have:

* Java 17/21+
* MySQL
* Git

### 1. Clone the repository

```bash
git clone https://github.com/Unavailable-Cat/Tasks-App-Backend.git
cd Tasks-App-Backend
```

### 2. Configure the database

Create a MySQL database and configure the required environment variables.

For example:

```text
DATASOURCE_URL=jdbc:mysql://localhost:3306/tasks
DATASOURCE_USERNAME=root
DATASOURCE_PASSWORD=your_password
DATASOURCE_DRIVER=com.mysql.cj.jdbc.Driver
```

### 3. Build the application

Using the Maven wrapper:

```bash
./mvnw clean package
```

On Windows:

```cmd
mvnw.cmd clean package
```

### 4. Run the application

```bash
java -jar target/<generated-jar-name>.jar
```

Alternatively, run the `TasksApplication` class directly from your IDE.

The backend will normally be available at:

```text
http://localhost:8080
```

## 🐳 Docker

The project includes a `Dockerfile` for containerized deployment.

Build the image:

```bash
docker build -t tasks-app-backend .
```

Run the container:

```bash
docker run -p 8080:8080 tasks-app-backend
```

Database credentials should be supplied through environment variables rather than being hardcoded into the Docker image.

## 🌐 Deployment

The backend can be deployed using a cloud hosting platform such as **Render**.

The application is designed to use environment variables for production database configuration, allowing the same codebase to be used across local and production environments.

Example architecture:

```text
React Frontend
      │
      ▼
Spring Boot REST API
      │
      ▼
MySQL Database
```

## 🎯 Purpose

This project was built as a practical full-stack application to demonstrate backend development using **Java, Spring Boot, REST APIs, JPA/Hibernate, MySQL, and Docker**, along with integration with a React frontend.

## 📌 Future Improvements

Potential improvements include:

* Authentication and authorization
* User-specific task management
* Task filtering and pagination
* Input validation and improved exception handling
* Automated testing
* API documentation with Swagger/OpenAPI
* CI/CD pipeline
* Production monitoring and logging

## 👨‍💻 Author

**Sanket Singh**

This project is part of my backend/full-stack development portfolio.
