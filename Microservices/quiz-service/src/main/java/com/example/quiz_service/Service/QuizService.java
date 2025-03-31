package com.example.quiz_service.Service;

import com.example.quiz_service.Repository.QuizRepo;
import com.example.quiz_service.feign.QuizInterface;
import com.example.quiz_service.model.QuestionWrapper;
import com.example.quiz_service.model.Quiz;
import com.example.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> create(String category, int numQ, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
        System.out.println(questions);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Integer> questionsIdsFromDB = quiz.getQuestionsIds();
        System.out.println(questionsIdsFromDB);
        List<QuestionWrapper> qw = quizInterface.getQuestionsFromIds(questionsIdsFromDB).getBody();
        return new ResponseEntity<>(qw, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(int id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Integer> questionsIds = quiz.getQuestionsIds();
        int score = quizInterface.getScore(responses).getBody();
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
