# Task 1 - Simple Database Connectivity (Spring Boot + JDBC + MySQL)

## What this project demonstrates
- Connect Spring Boot to MySQL using JDBC
- Auto-create table `student(sl, student_id)`
- Endpoints to verify DB connection and query table

## Requirements
- Java 17
- Maven
- Docker (recommended) OR any MySQL 8+

## Start MySQL quickly (Docker)
```bash
docker compose up -d
```

This creates:
- DB: `labdb`
- User: `root`
- Pass: `root`
- Port: `3306`

## Run the app
```bash
mvn spring-boot:run
```
App runs on **port 8081**.

## Test (Browser / Postman)
- Ping DB:
  - `GET http://localhost:8081/api/pingdb`
- Check student exists:
  - `GET http://localhost:8081/api/students/2026001/exists`
- Insert student (optional):
  - `POST http://localhost:8081/api/students`
  - Body: `{"studentId":"2026999"}`

## Postman
Import `postman_collection_task1.json`
