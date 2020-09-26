package com.example.demo.service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.PossibleAnswer;
import com.example.demo.model.Question;
import com.example.demo.repositories.AnswerRepository;
import com.example.demo.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionServiceImpl implements  QuestionService1 {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question question) {
        for(PossibleAnswer possibleAnswer : question.getPossibleAnswerSet()){
            if(answerRepository.findById(possibleAnswer.getId()).isPresent()) {
                answerRepository.findById(possibleAnswer.getId()).get().addQuestion(question);
            }
        }
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(long id, Question question) {
        Optional<Question> questionDB = this.questionRepository.findById(id);

        if(questionDB.isPresent()) {
            Question questionUpdate = questionDB.get();
            questionUpdate.setCustomAnswer(question.getCustomAnswer());
            questionUpdate.setQuestionText(question.getQuestionText());
            questionUpdate.setRequired(question.isRequired());
            questionUpdate.setPossibleAnswerSet(question.getPossibleAnswerSet());
            questionRepository.save(questionUpdate);
            return questionUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id :" + question.getId());
        }
    }

    @Override
    public Question getQuestionById(long id) {
        Optional<Question> questionDB = this.questionRepository.findById(id);
        if(questionDB.isPresent()) {
            return questionDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id :" + id);
        }
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public void deleteQuestion(long id) {
        Optional<Question> questionDB = this.questionRepository.findById(id);
        if(questionDB.isPresent()) {
            this.questionRepository.delete(questionDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id :" + id);
        }
    }
}
