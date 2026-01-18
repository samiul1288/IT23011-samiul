# Quiz App (Spring Boot + JDBC)

**Requirement covered**
- 2 questions, 4 MCQ options each
- Student must enter **Student ID** first
- App checks DB table **student(sl, student_id)**; only existing IDs can play
- Quiz can be played **only once** per Student ID (checked via `quiz_result`)
- Score + student_id saved into DB table `quiz_result`
- Questions & options are in **Bangla** (implemented for roll-ending digit **1** by default)

## 1) Run (easy mode - H2 in-memory DB)

```bash
mvn spring-boot:run
```

Open in browser:
- `http://localhost:8080/login`

H2 console (optional):
- `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:quizdb`
- User: `sa` (no password)

Sample students are inserted from `src/main/resources/data.sql`:
- `2026001`, `2026002`, `2026003`

## 2) MySQL setup (optional)

Create DB and tables:

```sql
CREATE DATABASE quizdb;
USE quizdb;

CREATE TABLE student (
  sl INT AUTO_INCREMENT PRIMARY KEY,
  student_id VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE quiz_result (
  id INT AUTO_INCREMENT PRIMARY KEY,
  student_id VARCHAR(50) NOT NULL,
  score INT NOT NULL,
  taken_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

Insert some students:

```sql
INSERT INTO student(student_id) VALUES ('2026001');
```

Then update `application.properties` like this (example):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.sql.init.mode=never
```

Also uncomment the MySQL dependency in `pom.xml`.

## 3) Roll-number ending digit mapping

In `src/main/resources/application.properties`:

```properties
quiz.topicDigit=1
```

Mapping:
- 1: Arithmetic (implemented)
- 2: Bangladesh Studies (add your 2 Bangla questions)
- 4: Physics (add your 2 Bangla questions)
- 5: Chemistry (add your 2 Bangla questions)
- 6: Bangla Grammar (add your 2 Bangla questions)
- 7: Geography (add your 2 Bangla questions)
- 8: History (add your 2 Bangla questions)
- 9: Economics (add your 2 Bangla questions)
- 0: International Studies (add your 2 Bangla questions)

To add your questions: edit `QuizService.java`.

## 4) GitHub submission

1. Rename the folder/repo to: `student_id_first_name`
2. Initialize git and push:

```bash
git init
git add .
git commit -m "Initial quiz project"
git branch -M main
git remote add origin https://github.com/<your-username>/student_id_first_name.git
git push -u origin main
```

Then submit the repository URL.
