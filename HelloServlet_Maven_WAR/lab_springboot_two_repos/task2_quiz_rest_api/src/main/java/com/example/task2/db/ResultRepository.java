package com.example.task2.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ResultRepository {
    private final JdbcTemplate jdbc;

    public ResultRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public boolean alreadyTaken(String studentId) {
        Integer count = jdbc.queryForObject(
                "SELECT COUNT(*) FROM quiz_result WHERE student_id = ?",
                Integer.class,
                studentId
        );
        return count != null && count > 0;
    }

    public void saveScore(String studentId, int score) {
        jdbc.update("INSERT INTO quiz_result(student_id, score) VALUES (?, ?)", studentId, score);
    }

    public Map<String, Object> latestResult(String studentId) {
        return jdbc.queryForMap(
                "SELECT student_id, score, taken_at FROM quiz_result WHERE student_id=? ORDER BY sl DESC LIMIT 1",
                studentId
        );
    }
}
