package com.example.demo.service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.PossibleAnswer;
import com.example.demo.repositories.AnswerRepository;
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
    public PossibleAnswer createAnswer(PossibleAnswer possibleAnswer) {
        return answerRepository.save(possibleAnswer);
    }

    @Override
    public PossibleAnswer updateAnswer(long id, PossibleAnswer possibleAnswer) {

        Optional<PossibleAnswer> answerDb = this.answerRepository.findById(id);

        if(answerDb.isPresent()) {
            PossibleAnswer possibleAnswerToUpdate = answerDb.get();
            possibleAnswerToUpdate.setText(possibleAnswer.getText());
//            possibleAnswerToUpdate.setQuestionSet(possibleAnswer.getQuestionSet());
            answerRepository.save(possibleAnswerToUpdate);
            return possibleAnswerToUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id :" + possibleAnswer.getId());
        }
    }

    @Override
    public PossibleAnswer getAnswerById(long id) {
        Optional<PossibleAnswer> answerDb = this.answerRepository.findById(id);
        if(answerDb.isPresent()) {
            return answerDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id :" + id);
        }
    }

    @Override
    public List<PossibleAnswer> getAllAnswer() {
        return answerRepository.findAll();
    }

    @Override
    public void deleteAnswer(long id) {
        Optional<PossibleAnswer> answerDb = this.answerRepository.findById(id);
        if(answerDb.isPresent()) {
            this.answerRepository.delete(answerDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id :" + id);
        }
    }
}
