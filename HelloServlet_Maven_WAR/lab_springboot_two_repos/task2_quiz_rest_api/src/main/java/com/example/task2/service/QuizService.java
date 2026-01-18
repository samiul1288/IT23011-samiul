package com.example.task2.service;

import com.example.task2.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NOTE: Update questions based on your roll-number last digit topic.
 * Current sample: digit=1 (Arithmetic) in Bangla, high-school standard.
 */
@Service
public class QuizService {

    // Correct answers by option index (0..3), in order.
    private final List<Integer> correct = List.of(1, 2);

    public List<Question> getQuestions() {
        return List.of(
                new Question(
                        1,
                        "প্রশ্ন ১: ১৫ + ২৭ = কত?",
                        List.of("৩২", "৪২", "৪০", "৪৪")
                ),
                new Question(
                        2,
                        "প্রশ্ন ২: ৮ × ৭ = কত?",
                        List.of("৪৮", "৫৪", "৫৬", "৬২")
                )
        );
    }

    public int calculateScore(List<Integer> answers) {
        int score = 0;
        for (int i = 0; i < correct.size() && i < answers.size(); i++) {
            if (answers.get(i) != null && answers.get(i).equals(correct.get(i))) {
                score++;
            }
        }
        return score;
    }
}
