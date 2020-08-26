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
        return 0;
    }

    @Override
    public int updateSurveyById(UUID id, Survey survey) {
        return 0;
    }

    private static List<Survey> DB = new ArrayList<>();

    @Override
    public int insertSurvey(UUID id, Survey survey) {
        DB.add(new Survey(id, survey.getTitle(), survey.isOpen()));
        return 1;
    }

    @Override
    public List<Survey> selectAllSurveys() {
        return DB;
    }
}
