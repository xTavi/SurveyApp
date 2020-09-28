package com.example.demo.controllers;

import com.example.demo.model.Survey;
import com.example.demo.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/survey")
@RestController
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        return ResponseEntity.ok().body(surveyService.getAllSurvey());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(surveyService.getSurveyById(id));
    }

    @PostMapping
    public ResponseEntity<Survey> createSurvey (@RequestBody Survey survey) {
        return ResponseEntity.ok().body(surveyService.createSurvey(survey));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Survey survey) {
        return ResponseEntity.ok().body(surveyService.updateSurvey(id, survey));
    }

    @DeleteMapping(path = "{id}")
    public HttpStatus deleteSurveyById(@PathVariable("id") UUID id) {
        surveyService.deleteSurvey(id);
        return HttpStatus.OK;
    }
}
