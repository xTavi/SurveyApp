package com.example.demo.service;

import com.example.demo.dao.SurveyDao;
import com.example.demo.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SurveyService {

    private final SurveyDao surveyDao;

    @Autowired
    public SurveyService(@Qualifier("fakeDao") SurveyDao surveyDao){
        this.surveyDao = surveyDao;
    }

    public int addSurvey(Survey survey) {
        return surveyDao.insertSurvey(survey);
    }

    public List<Survey> getAllSurveys() {
        return surveyDao.selectAllSurveys();
    }

    public Optional<Survey> getSurveyById(UUID id){ return surveyDao.selectSurveyById(id); }

    public int deleteSurvey(UUID id){
        return surveyDao.deleteSurveyById(id);
    }

    public int updateSurvey(UUID id, Survey survey) {
        return surveyDao.updateSurveyById(id, survey);
    }

}
