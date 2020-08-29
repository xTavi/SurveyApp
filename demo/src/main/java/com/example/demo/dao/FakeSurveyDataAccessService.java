package com.example.demo.dao;

import com.example.demo.model.Survey;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository("fakeDao")
public class FakeSurveyDataAccessService implements SurveyDao {

    @Override
    public Optional<Survey> selectSurveyById(UUID id) {
        return DB.stream()
                .filter(survey -> survey.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteSurveyById(UUID id) {

       Optional<Survey> surveyMaybe = selectSurveyById(id);
       if(surveyMaybe.isEmpty()) {
           return 0;
       }
       DB.remove(surveyMaybe.get());
       return 1;
    }

    @Override
    public int updateSurveyById(UUID id, Survey updateSurvey) {
        return selectSurveyById(id)
                .map(survey -> {
                    int indexOfSurveyToUpdate = DB.indexOf(survey);
                    if(indexOfSurveyToUpdate >= 0) {
                        DB.set(indexOfSurveyToUpdate, new Survey(id, updateSurvey.getTitle(), updateSurvey.isOpen(), updateSurvey.getQuestionList()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    private static final List<Survey> DB = new ArrayList<>();

    @Override
    public int insertSurvey(UUID id, Survey survey) {
        DB.add(new Survey(id, survey.getTitle(), survey.isOpen(), survey.getQuestionList()));
        return 1;
    }

    @Override
    public List<Survey> selectAllSurveys() {
        return DB;
    }
}
