package com.example.task1.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbc;

    public StudentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public String selectNow() {
        // Works on MySQL and H2; on MySQL returns datetime; on H2 returns timestamp
        return jdbc.queryForObject("SELECT NOW()", String.class);
    }

    public boolean existsByStudentId(String studentId) {
        Integer count = jdbc.queryForObject(
                "SELECT COUNT(*) FROM student WHERE student_id = ?",
                Integer.class,
                studentId
        );
        return count != null && count > 0;
    }

    public void insertStudent(String studentId) {
        jdbc.update("INSERT INTO student(student_id) VALUES (?)", studentId);
    }
}
