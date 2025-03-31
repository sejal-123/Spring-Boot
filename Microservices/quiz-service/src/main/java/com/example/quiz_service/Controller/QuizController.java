package com.example.quiz_service.Controller;

import com.example.quiz_service.Service.QuizService;
import com.example.quiz_service.model.QuestionWrapper;
import com.example.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return quizService.create(category, numQ, title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id) {
        return quizService.getQuiz(id);
    }

    @GetMapping("/submit/{id}")
    public ResponseEntity<Integer> getScore(@PathVariable int id, @RequestBody List<Response> responses) {
        return quizService.getScore(id, responses);
    }

}
