package com.example.quiz.repo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ResultRepository {
    private final JdbcTemplate jdbcTemplate;

    public ResultRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean hasTakenQuiz(String studentId) {
        Integer cnt = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM quiz_result WHERE student_id = ?", Integer.class, studentId);
        return cnt != null && cnt > 0;
    }

    public void saveResult(String studentId, int score) {
        jdbcTemplate.update(
                "INSERT INTO quiz_result(student_id, score) VALUES (?, ?)",
                studentId, score
        );
    }
}
