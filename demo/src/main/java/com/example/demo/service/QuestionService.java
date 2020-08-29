//package com.example.demo.service;
//
//import com.example.demo.dao.QuestionDao;
//import com.example.demo.model.Question;
//import com.example.demo.model.Survey;
//import com.example.demo.repositories.QuestionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class QuestionService {
//
//    private final QuestionDao questionDao;
//
//    @Autowired
//    public QuestionService(@Qualifier("questions") QuestionDao questionDao) { this.questionDao = questionDao; }
//
//    public int addQuestion(Question question){
//        return questionDao.insertQuestion(question.getId(), question);
//    }
//
//    public List<Question> getAllQuestions() {
//        return questionDao.selectAllQuestions();
//    }
//
//}
