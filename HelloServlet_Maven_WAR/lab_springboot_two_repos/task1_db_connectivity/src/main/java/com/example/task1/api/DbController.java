package com.example.task1.api;

import com.example.task1.db.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DbController {

    private final StudentRepository repo;

    public DbController(StudentRepository repo) {
        this.repo = repo;
    }

    // Task 1: prove DB connection works
    @GetMapping("/pingdb")
    public ResponseEntity<?> pingDb() {
        return ResponseEntity.ok(Map.of(
                "ok", true,
                "dbTime", repo.selectNow()
        ));
    }

    // Show student table exists and can query
    @GetMapping("/students/{studentId}/exists")
    public ResponseEntity<?> studentExists(@PathVariable String studentId) {
        boolean exists = repo.existsByStudentId(studentId);
        return ResponseEntity.ok(Map.of("studentId", studentId, "exists", exists));
    }

    // Insert a new student id for quick testing (optional)
    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Map<String, String> body) {
        String studentId = body.get("studentId");
        if (studentId == null || studentId.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "studentId is required"));
        }
        repo.insertStudent(studentId.trim());
        return ResponseEntity.ok(Map.of("inserted", true, "studentId", studentId.trim()));
    }
}
