package com.example.quiz_service.feign;

import com.example.quiz_service.model.QuestionWrapper;
import com.example.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("question-service")
public interface QuizInterface {
    @GetMapping("/question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam int numQ);

    @PostMapping("/question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(@RequestBody List<Integer> questionIds);

    @PostMapping("/question/score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
