package com.example.task2.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbc;

    public StudentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public boolean existsByStudentId(String studentId) {
        Integer count = jdbc.queryForObject(
                "SELECT COUNT(*) FROM student WHERE student_id = ?",
                Integer.class,
                studentId
        );
        return count != null && count > 0;
    }
}
