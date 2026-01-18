# Live Lab Submission Guide (Two GitHub Repositories)

Canvas pages are login-protected, so this ZIP includes **two complete Spring Boot projects** that match the common lab requirements:
- **Task 1**: Simple DB connectivity using Spring Boot + JDBC + MySQL
- **Task 2**: Spring Boot REST API + Postman + MySQL (Quiz with student validation + score save)

## Best practice for full marks (my decision)
Create **two separate GitHub repositories** (one per task), so the teacher can check each requirement clearly.

Recommended repository names (replace with your real values):
- `student_id_first_name_task1`
- `student_id_first_name_task2`

Example:
- `20231234_samiul_task1`
- `20231234_samiul_task2`

## Step-by-step: create and push Task 1 repo
1) Open folder: `task1_db_connectivity`
2) In terminal:
```bash
git init
git add .
git commit -m "Task 1 - DB connectivity"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```

## Step-by-step: create and push Task 2 repo
1) Open folder: `task2_quiz_rest_api`
2) In terminal:
```bash
git init
git add .
git commit -m "Task 2 - Quiz REST API"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```

## Quick run checklist (for screenshots / viva)
1) Start MySQL:
```bash
docker compose up -d
```
(run from each task folder OR copy the docker-compose.yml once and run it)

2) Run Task 1:
```bash
mvn spring-boot:run
```
Test:
- GET `http://localhost:8081/api/pingdb`

3) Run Task 2:
```bash
mvn spring-boot:run
```
Test flow (Postman collections are included):
- POST `/api/quiz/start`
- GET `/api/quiz/questions`
- POST `/api/quiz/submit`

## Important
If your roll-last-digit topic isn't Arithmetic, change questions in:
- Task 2 -> `QuizService.java` (Bangla questions + 4 options, 2 questions)
