# Student Management REST API (Spring Boot)

Welcome to the **Student Management REST API**! This project is built using **Spring Boot** and provides a clean and simple backend for managing student data. The API supports common CRUD operations and is designed to be easy for developers and learners to understand and extend.

---

## 📌 **Table of Contents**

1. [Overview](#overview)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Project Structure](#project-structure)
5. [How to Run the Project](#how-to-run-the-project)
6. [API Endpoints](#api-endpoints)
7. [Database Schema](#database-schema)
8. [Future Improvements](#future-improvements)
9. [License](#license)

---

## 📝 **Overview**

The **Student Management REST API** allows you to manage student records through a modern RESTful interface. You can create, read, update, and delete student information. This project is ideal for learning Spring Boot, REST principles, and backend application development.

---

## ✨ **Features**

* 🆕 Add new student records
* 📄 View a list of all students
* 🔍 Retrieve a single student by ID
* ✏️ Update student details
* 🗑️ Delete a student
* 🔎 Search functionality 
* 📄 Pagination & Sorting 

---

## 🛠️ **Technologies Used**

* **Java 17+**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate ORM**
* **MySQL Database** 
* **Maven**

---

## 📂 **Project Structure**

```
src/main/java/com/student/studentcrud
│
├── controller/        → REST controllers (API endpoints)
├── Model/            → JPA Entity classes (Student)
├── repository/        → JPA repository interfaces
├── service/           → Service layer for business logic
└── StudentCrudApplication.java → Main application entry
```

---

## ▶️ **How to Run the Project**

### **1. Clone the repository**

```
git clone https://github.com/Udara01/Student-Management.git
```

### **2. Open the project in your IDE**

Recommended: IntelliJ IDEA / Eclipse / VS Code + Java extension

### **3. Configure the database**

Edit `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```


### **4. Run the application**

You can use:

```
mvn clean install
mvn spring-boot:run
```

or run via your IDE.

The application will start on:

```
http://localhost:8082
```

---

## 📘 API Documentation (Swagger)
Swagger UI is included in this project for easy testing and understanding of all API endpoints.
After running the application, open
```angular2html
http://localhost:8080/swagger-ui/index.html
```
You can explore, test, and view request/response structures directly in the browser.


---



## 📡 **API Endpoints**

### **1. Get all students**

```
GET api/students
```

### **2. Get student by ID**

```
GET api/students/{id}
```

### **3. Add a new student**

```
POST api/students
```

**Body Example:**

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "age": 21
}
```

### **4. Update a student**

```
PUT api/students/{id}
```

### **5. Delete a student**

```
DELETE api/students/{id}
```


### **6. Search student**

```
GET api/students/search?name=John
```

---

## 🗄️ **Database Schema**

A simple `Student` table:

```
Student
-------
ID (Primary Key)
Name
Email
Age
CreatedAt (Optional)
UpdatedAt (Optional)
```

---

## 🚀 **Future Improvements**

Here are possible enhancements:

* ➕ Add Course entity and relationships
* 🔐 Add authentication (Spring Security + JWT)
* 🧪 Add unit & integration tests (JUnit)
* 📘 Add Swagger API documentation
* 🔄 Add sorting & advanced filters
* 🖥️ Build frontend using React/Angular/Vue

---

## 📄 **License**

This project is licensed under the **MIT License**.

---
