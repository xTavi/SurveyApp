package com.example.demo.service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Survey;
import com.example.demo.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class SurveyServiceImpl implements SurveyService1 {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Survey updateSurvey(UUID id, Survey survey) {
        Optional<Survey> surveyDB = this.surveyRepository.findById(id);

        if (surveyDB.isPresent()) {
            Survey surveyToUpdate = surveyDB.get();
            surveyToUpdate.setOpen(survey.isOpen());
            surveyToUpdate.setTitle(survey.getTitle());
            surveyToUpdate.setQuestionList(survey.getQuestionList());
            surveyRepository.save(surveyToUpdate);
            return surveyToUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id:" + survey.getId());
        }
    }

    @Override
    public Survey getSurveyById(UUID id) {
        Optional<Survey> surveyDB = this.surveyRepository.findById(id);

        if (surveyDB.isPresent()) {
            return surveyDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id:" + id);
        }
    }

    @Override
    public List<Survey> getAllSurvey() {
        return surveyRepository.findAll();
    }

    @Override
    public void deleteSurvey(UUID id) {
        Optional<Survey> surveyDB = this.surveyRepository.findById(id);

        if (surveyDB.isPresent()) {
            this.surveyRepository.delete(surveyDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id:" + id);
        }
    }
}
