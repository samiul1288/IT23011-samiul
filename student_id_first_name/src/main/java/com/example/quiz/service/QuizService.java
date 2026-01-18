package com.example.quiz.service;

import com.example.quiz.model.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Value("${quiz.topicDigit:1}")
    private int topicDigit;

    /**
     * NOTE: For this submission, the full question set is implemented for digit=1 (Arithmetic).
     * If your roll-number ends with another digit, open this file and add your own 2 Bangla questions
     * in the corresponding method.
     */
    public String getTopicName() {
        return switch (topicDigit) {
            case 1 -> "\u0997\u09A3\u09BF\u09A4 (\u09AA\u09BE\u099F\u09BF\u0997\u09A3\u09BF\u09A4)"; // à¦à¦£à¦¿à¦¤ (à¦ªà¦¾à¦à¦¿à¦à¦£à¦¿à¦¤)
            case 2 -> "\u09AC\u09BE\u0982\u09B2\u09BE\u09A6\u09C7\u09B6 \u09AA\u09B0\u09BF\u099A\u09DF"; // à¦¬à¦¾à¦à¦²à¦¾à¦¦à§à¦¶ à¦ªà¦°à¦¿à¦à§
            case 4 -> "\u09AA\u09A6\u09BE\u09B0\u09CD\u09A5\u09AC\u09BF\u099C\u09CD\u099E\u09BE\u09A8"; // à¦ªà¦¦à¦¾à¦°à§à¦¥à¦¬à¦¿à¦à§à¦à¦¾à¦¨
            case 5 -> "\u09B0\u09B8\u09BE\u09DF\u09A8"; // à¦°à¦¸à¦¾à§à¦¨
            case 6 -> "\u09AC\u09BE\u0982\u09B2\u09BE \u09AC\u09CD\u09AF\u09BE\u0995\u09B0\u09A3"; // à¦¬à¦¾à¦à¦²à¦¾ à¦¬à§à¦¯à¦¾à¦à¦°à¦£
            case 7 -> "\u09AD\u09C2\u0997\u09CB\u09B2"; // à¦­à§à¦à§à¦²
            case 8 -> "\u0987\u09A4\u09BF\u09B9\u09BE\u09B8"; // à¦à¦¤à¦¿à¦¹à¦¾à¦¸
            case 9 -> "\u0985\u09B0\u09CD\u09A5\u09A8\u09C0\u09A4\u09BF"; // à¦à¦°à§à¦¥à¦¨à§à¦¤à¦¿
            case 0 -> "\u0986\u09A8\u09CD\u09A4\u09B0\u09CD\u099C\u09BE\u09A4\u09BF\u0995 \u09AA\u09B0\u09BF\u099A\u09DF"; // à¦à¦¨à§à¦¤à¦°à§à¦à¦¾à¦¤à¦¿à¦ à¦ªà¦°à¦¿à¦à§
            default -> "\u0995\u09C1\u0987\u099C"; // à¦à§à¦à¦
        };
    }

    public List<Question> getQuestions() {
        return switch (topicDigit) {
            case 1 -> arithmetic();
            default -> arithmetic();
        };
    }

    public int evaluate(List<Question> questions, Integer a1, Integer a2) {
        int score = 0;
        if (a1 != null && a1 == questions.get(0).getCorrectIndex()) score++;
        if (a2 != null && a2 == questions.get(1).getCorrectIndex()) score++;
        return score;
    }

    private List<Question> arithmetic() {
        // 2 questions, 4 options each (Bangla)
        return List.of(
            new Question(
                1,
                "\u09E7\u09E8 + \u09E7\u09EB = ?", // à§§à§¨ + à§§à§« = ?
                List.of(
                    "\u09E8\u09EB", // à§¨à§«
                    "\u09E8\u09EC", // à§¨à§¬
                    "\u09E8\u09ED", // à§¨à§­
                    "\u09E8\u09EE"  // à§¨à§®
                ),
                2
            ),
            new Question(
                2,
                "\u09EC \u00D7 \u09ED = ?", // à§¬ Ã à§­ = ?
                List.of(
                    "\u09E9\u09EC", // à§©à§¬
                    "\u09EA\u09E8", // à§ªà§¨
                    "\u09EA\u09EE", // à§ªà§®
                    "\u09EB\u09EC"  // à§«à§¬
                ),
                1
            )
        );
    }
}
