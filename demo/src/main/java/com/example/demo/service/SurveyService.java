package com.example.demo.service;

import com.example.demo.model.Survey;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public interface SurveyService {

        Survey createSurvey(Survey survey);
        Survey updateSurvey(UUID id, Survey survey);
        Survey getSurveyById(UUID id);
        List<Survey> getAllSurvey();
        void deleteSurvey(UUID id);

}
