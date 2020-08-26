package com.example.demo.service;

import com.example.demo.dao.SurveyDao;
import com.example.demo.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

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
    };
}
