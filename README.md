# Todo List Application

A full-stack Todo List application with Spring Boot backend and a JavaScript + Bootstrap frontend.

---

## Project Structure

- `todo-list-backend/`: Spring Boot REST API backend handling task CRUD operations and data persistence.
- `todo-list-frontend/`: Frontend with HTML, JavaScript, and Bootstrap for user interface and interaction with backend APIs.

---

## Features

- Create, read, update, and delete tasks.
- Task fields: Title, Description, Status (Pending, In Progress, Completed, Cancelled).
- Responsive frontend UI using Bootstrap.
- Backend exposes RESTful API endpoints for data management.
- Data persistence with H2 (in-memory) / optionally other databases.

---

## Technologies Used

- Java 21, Spring Boot 3.5.4, Spring Data JPA
- H2 database (default, in-memory)
- HTML, JavaScript (vanilla), Bootstrap 5
- Git version control

---

## Getting Started

### Backend

1. Navigate to `todo-list-backend` folder.
2. Build and run the Spring Boot application:
3. The backend API will be available at `http://localhost:8080/api`.

### Frontend

1. Navigate to `todo-list-frontend` folder.
2. Open `index.html` in a browser or serve it using VS Code Live Server extension.
3. The frontend will communicate with backend API to manage tasks.

---

## Configuration

- Backend database settings can be adjusted in `application.properties` inside the backend resources.
- CORS enabled for frontend communication.

---

## Contribution

Feel free to fork and submit pull requests to improve this project.

---

## Contact
Created by Gourav Salaria  
Email: 01.gouravsalaria@gmail.com  
GitHub: https://github.com/gouravsalaria08
