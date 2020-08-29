package com.example.demo.service;

import com.example.demo.model.Question;

import java.util.List;

public interface QuestionService1 {

   Question createQuestion(Question question);
   Question updateQuestion(long id, Question question);
   Question getQuestionById(long id);
   List<Question> getAllQuestion();
   void deleteQuestion(long id);

}
