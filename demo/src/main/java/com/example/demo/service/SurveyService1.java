package com.example.demo.service;

import com.example.demo.model.Survey;

import java.util.List;
import java.util.UUID;

public interface SurveyService1 {

        Survey createSurvey(Survey survey);
        Survey updateSurvey(UUID id, Survey survey);
        Survey getSurveyById(UUID id);
        List<Survey> getAllSurvey();
        void deleteSurvey(UUID id);
}
