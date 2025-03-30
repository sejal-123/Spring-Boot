package com.example.QuizApp.Repository;

import com.example.QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Number> {

    List<Question> findByCategory(String category);
}
