package com.example.demo.dao;

import com.example.demo.model.Question;
import com.example.demo.model.Survey;
import com.example.demo.repositories.QuestionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionDao extends JpaRepository<Question, Long> {

    int insertQuestion(long id, Question question);

    List<Question> selectAllQuestions();
}
