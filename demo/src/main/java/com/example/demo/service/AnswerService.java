package com.example.demo.service;

import com.example.demo.model.Answer;

import java.util.List;

public interface AnswerService {
    Answer createAnswer(Answer Answer);
    Answer updateAnswer(long id, Answer Answer);
    Answer getAnswerById(long id);
    List<Answer> getAllAnswer();
    void deleteAnswer(long id);

}
