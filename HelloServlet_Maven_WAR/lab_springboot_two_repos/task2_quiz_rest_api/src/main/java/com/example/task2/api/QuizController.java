package com.example.task2.api;

import com.example.task2.api.dto.StartRequest;
import com.example.task2.api.dto.SubmitRequest;
import com.example.task2.db.ResultRepository;
import com.example.task2.db.StudentRepository;
import com.example.task2.model.Question;
import com.example.task2.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final StudentRepository studentRepo;
    private final ResultRepository resultRepo;
    private final QuizService quizService;

    public QuizController(StudentRepository studentRepo, ResultRepository resultRepo, QuizService quizService) {
        this.studentRepo = studentRepo;
        this.resultRepo = resultRepo;
        this.quizService = quizService;
    }

    /**
     * Step 1: Enter studentId to start.
     * - must exist in table student
     * - must not have already taken quiz
     */
    @PostMapping("/start")
    public ResponseEntity<?> start(@Valid @RequestBody StartRequest req) {
        String studentId = req.getStudentId().trim();

        if (!studentRepo.existsByStudentId(studentId)) {
            return ResponseEntity.status(403).body(Map.of(
                    "allowed", false,
                    "reason", "Student ID not found in database",
                    "studentId", studentId
            ));
        }
        if (resultRepo.alreadyTaken(studentId)) {
            return ResponseEntity.status(409).body(Map.of(
                    "allowed", false,
                    "reason", "This student already took the quiz once",
                    "studentId", studentId,
                    "result", resultRepo.latestResult(studentId)
            ));
        }
        return ResponseEntity.ok(Map.of("allowed", true, "studentId", studentId));
    }

    /**
     * Step 2: Fetch questions (Bangla)
     */
    @GetMapping("/questions")
    public ResponseEntity<List<Question>> questions() {
        return ResponseEntity.ok(quizService.getQuestions());
    }

    /**
     * Step 3: Submit answers, score will be saved in DB.
     * answers: list of option indexes 0..3
     */
    @PostMapping("/submit")
    public ResponseEntity<?> submit(@Valid @RequestBody SubmitRequest req) {
        String studentId = req.getStudentId().trim();

        if (!studentRepo.existsByStudentId(studentId)) {
            return ResponseEntity.status(403).body(Map.of(
                    "saved", false,
                    "reason", "Student ID not found in database",
                    "studentId", studentId
            ));
        }
        if (resultRepo.alreadyTaken(studentId)) {
            return ResponseEntity.status(409).body(Map.of(
                    "saved", false,
                    "reason", "This student already took the quiz once",
                    "studentId", studentId,
                    "result", resultRepo.latestResult(studentId)
            ));
        }

        int score = quizService.calculateScore(req.getAnswers());
        resultRepo.saveScore(studentId, score);

        return ResponseEntity.ok(Map.of(
                "saved", true,
                "studentId", studentId,
                "score", score,
                "totalQuestions", quizService.getQuestions().size()
        ));
    }
}
