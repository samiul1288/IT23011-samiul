package com.example.task2.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class SubmitRequest {
    @NotBlank
    private String studentId;

    // answers are option indexes: 0..3 for each question in order
    @NotNull
    private List<Integer> answers;

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public List<Integer> getAnswers() { return answers; }
    public void setAnswers(List<Integer> answers) { this.answers = answers; }
}
