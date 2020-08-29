package com.example.demo.service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Answer;
import com.example.demo.repositories.AnswerRepository;
import com.example.demo.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;


    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer updateAnswer(long id, Answer answer) {

        Optional<Answer> answerDb = this.answerRepository.findById(id);

        if(answerDb.isPresent()) {
            Answer answerToUpdate = answerDb.get();
            answerToUpdate.setText(answer.getText());
            answerToUpdate.setQuestion(answer.getQuestion());
            answerRepository.save(answerToUpdate);
            return answerToUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id :" + answer.getId());
        }
    }

    @Override
    public Answer getAnswerById(long id) {
        Optional<Answer> answerDb = this.answerRepository.findById(id);
        if(answerDb.isPresent()) {
            return answerDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id :" + id);
        }
    }

    @Override
    public List<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }

    @Override
    public void deleteAnswer(long id) {
        Optional<Answer> answerDb = this.answerRepository.findById(id);
        if(answerDb.isPresent()) {
            this.answerRepository.delete(answerDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id :" + id);
        }
    }
}
