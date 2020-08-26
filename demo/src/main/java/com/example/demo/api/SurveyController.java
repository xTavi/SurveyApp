package com.example.demo.api;

import com.example.demo.service.SurveyService;
import com.example.demo.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/survey")
@RestController
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping
    public void addSurvey(@RequestBody Survey survey) {
        surveyService.addSurvey(survey);
    }

    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    @GetMapping(path = "{id}")
    public Survey getSurveyById(@PathVariable("id") UUID id){
        return surveyService.getSurveyById(id).orElse(null);
    }
}
