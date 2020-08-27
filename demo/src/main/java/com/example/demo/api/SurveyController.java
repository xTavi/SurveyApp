package com.example.demo.api;

import com.example.demo.service.SurveyService;
import com.example.demo.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    public void addSurvey(@Valid @NotNull @RequestBody Survey survey) {
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

    @DeleteMapping(path = "{id}")
    public void deleteSurveyById(@PathVariable("id") UUID id) {  surveyService.deleteSurvey(id); }

    @PutMapping(path = "{id}")
    public void updateSurvey(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Survey surveyToUpdate) {
        surveyService.updateSurvey(id, surveyToUpdate);
    }
}
