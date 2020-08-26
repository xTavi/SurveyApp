package com.example.demo.dao;

import com.example.demo.model.Survey;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

@Repository("fakeDao")
public class FakeSurveyDataAccessService implements SurveyDao {

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
