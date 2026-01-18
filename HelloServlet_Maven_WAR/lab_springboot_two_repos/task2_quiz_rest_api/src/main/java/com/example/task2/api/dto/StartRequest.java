package com.example.task2.api.dto;

import jakarta.validation.constraints.NotBlank;

public class StartRequest {
    @NotBlank
    private String studentId;

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
}
