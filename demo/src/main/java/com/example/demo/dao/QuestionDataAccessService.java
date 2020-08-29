//package com.example.demo.dao;
//
//import com.example.demo.model.Question;
//import com.example.demo.model.Survey;
//import com.example.demo.repositories.QuestionRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository("questions")
//public class QuestionDataAccessService implements QuestionDao {
//
//    QuestionRepository repository;
//
//    public int insertQuestion(long id, Question question) {
//        repository.save(new Question(id, question.getQuestionText(), question.isRequired(), question.getCustomAnswer()));
//        return 1;
//    }
//
//    public List<Question> selectAllQuestions() {
//        return repository.findAll();
//    }
//
//
//}
