# Task 2 - Spring Boot REST API + Postman + MySQL (Quiz)

## What this project demonstrates
- Spring Boot REST API (JSON)
- JDBC + MySQL connection
- Student ID validation from `student` table
- Quiz attempt allowed only once per student
- Save score into DB table `quiz_result`

## Requirements
- Java 17
- Maven
- Docker (recommended) OR any MySQL 8+

## Start MySQL (Docker)
```bash
docker compose up -d
```

DB details:
- DB: `labdb`
- User: `root`
- Pass: `root`
- Port: `3306`

## Run the app
```bash
mvn spring-boot:run
```
App runs on **port 8082**.

## API Flow (as in Lab requirement)
1) Enter Student ID (must exist) -> start
- `POST http://localhost:8082/api/quiz/start`
  Body:
  ```json
  { "studentId": "2026001" }
  ```

2) Get Questions
- `GET http://localhost:8082/api/quiz/questions`

3) Submit Answers and Save Score
- `POST http://localhost:8082/api/quiz/submit`
  Body:
  ```json
  { "studentId": "2026001", "answers": [1, 2] }
  ```

## Postman
Import `postman_collection_task2.json`

## Bangla Questions
Questions and options are in Bangla (high-school standard).
If your roll-last-digit topic is different, update questions in:
- `src/main/java/com/example/task2/service/QuizService.java`
