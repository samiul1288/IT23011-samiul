package com.example.quiz.repo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean existsByStudentId(String studentId) {
        Integer cnt = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM student WHERE student_id = ?", Integer.class, studentId);
        return cnt != null && cnt > 0;
    }
}
