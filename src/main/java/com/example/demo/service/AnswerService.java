package com.example.demo.service;

import com.example.demo.model.PossibleAnswer;

import java.util.List;

public interface AnswerService {
    PossibleAnswer createAnswer(PossibleAnswer PossibleAnswer);
    PossibleAnswer updateAnswer(long id, PossibleAnswer PossibleAnswer);
    PossibleAnswer getAnswerById(long id);
    List<PossibleAnswer> getAllAnswer();
    void deleteAnswer(long id);

}
