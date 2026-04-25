# Fundamentals of Spring and Architecture

**Course:** Advanced Programming - 7th Level  
**University:** Universidad de las Fuerzas Armadas ESPE - Santo Domingo, Ecuador  
**Student:** Alexandra Adriana Tana España  
**Instructor:** Ing. Jhon Cruz

---

## Description
This project demonstrates three fundamental concepts of the Spring Framework:
1. Dependency Injection (IoC)
2. Exception Handling
3. HTTP Interceptors

---

## Project Structure
src/main/java/com/espe/springfundamentalsale/
├── config/          → WebConfig (interceptor registration)
├── controller/      → UserController (REST endpoints)
├── exception/       → GlobalExceptionHandler, ErrorResponse, UserNotFoundException
├── interceptor/     → LoggingInterceptor, AuthInterceptor
├── model/           → User
└── service/         → UserService

---

## How to Run
1. Clone the repository
2. Open in IntelliJ IDEA
3. Run `SpringFundamentalsAleApplication.java`
4. Server starts on `http://localhost:8080`

---

## API Endpoints

| Method | URL | Description | Auth Required |
|--------|-----|-------------|---------------|
| GET | `/api/users/public/all` | Get all users | No |
| GET | `/api/users/{id}` | Get user by ID | Yes (Bearer token) |

---

## Test the API

**Get all users (public):**
GET http://localhost:8080/api/users/public/all

**Get user by ID (requires token):**
GET http://localhost:8080/api/users/1
Authorization: Bearer mytoken123

**User not found (404):**
GET http://localhost:8080/api/users/99
---

## Key Concepts

### 1. Dependency Injection (IoC)
Spring automatically injects `UserService` into `UserController` using `@Autowired`. No manual `new` keyword needed.

### 2. Exception Handling
`GlobalExceptionHandler` catches exceptions globally using `@RestControllerAdvice` and returns proper HTTP responses (404, 400, 500).

### 3. HTTP Interceptors
- `LoggingInterceptor` → logs every request with timing
- `AuthInterceptor` → validates Bearer token on protected routes

---

## Technologies
- Java 17
- Spring Boot 4.0.6
- Maven