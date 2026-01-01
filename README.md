# User Management System – Spring Boot

A Spring Boot based **User Management REST API** that provides secure user authentication and authorization using **JWT**, along with clean architecture, testing, and code quality checks.

This project was developed as part of a technical assignment and follows industry best practices.

---

## ✨ Features & Requirements Covered

- User login and registration functionality
- JWT token-based authentication
- Role-based access control (USER / ADMIN)
- Request payload validation using Bean Validation
- Unit tests with more than **80% test coverage**
- SonarQube integration for code quality analysis
- Application packaged and deployed as a runnable JAR
- Clear setup and run instructions

---

## 🛠 Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **MySQL**
- **Maven**
- **JUnit & Mockito**
- **SonarQube**

---

## 🚀 How to Run the Application

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Ganesh-Sonune/user-management.git
cd user-management
```
### 2️⃣ Configure Database

Create a MySQL database:
```
CREATE DATABASE user_management;
```
Update the database configuration in application.properties:
```agsl
spring.datasource.url=jdbc:mysql://localhost:3306/user_management
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
```
### 3️⃣ Build the Project

Use Maven to build the project:
```agsl
mvn clean package
```

### 4️⃣ Run the Application
```agsl
java -jar target/user-management-0.0.1-SNAPSHOT.jar
```

## 👨‍💻 Author

**Ganesh Sonune**  
GitHub: https://github.com/Ganesh-Sonune
