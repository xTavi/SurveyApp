package com.example.demo.dao;
import com.example.demo.model.Survey;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface SurveyDao {

    int insertSurvey(UUID id, Survey survey);

    default int insertSurvey(Survey survey){
        UUID id = UUID.randomUUID();
        return insertSurvey(id, survey);
    }

    List<Survey> selectAllSurveys();

    Optional<Survey> selectSurveyById(UUID id);

    int deleteSurveyById(UUID id);

    int updateSurveyById(UUID id, Survey survey);
}
