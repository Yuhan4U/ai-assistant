package com.yuhan.test.web.demoweb.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuhan.test.web.demoweb.db.UserScoreRepository;
import com.yuhan.test.web.demoweb.pojo.Question;
import com.yuhan.test.web.demoweb.pojo.UserScore;
import com.yuhan.test.web.demoweb.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private UserScoreRepository userScoreRepository;

    // Get N random questions
    @GetMapping("/random")
    public ResponseEntity<List<Question>> getRandomQuestions(@RequestParam(defaultValue = "3") int count) {
        List<Question> questions = quizService.getRandomQuestions(count);
        return ResponseEntity.ok(questions);
    }

    // Submit score for a user
    @PostMapping("/submit")
    public ResponseEntity<String> submitScore(@RequestBody Map<String, Object> payload) {
        String username = (String) payload.get("username");
        String standard = (String) payload.get("standard");
        int score = (int) payload.get("score");

        UserScore userScore = new UserScore(username, standard, score);
        userScoreRepository.save(userScore);

        return ResponseEntity.ok("Score saved successfully!");
    }

    // Get top scorer
    @GetMapping("/top")
    public ResponseEntity<List<UserScore>> getTopScorer() {
        List<UserScore> top = userScoreRepository.findTop5ByOrderByScoreDesc();
        if (!top.isEmpty()) return ResponseEntity.ok(top);
        return ResponseEntity.ok(null);
    }
}
