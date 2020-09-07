package com.example.demo.controllers;

import com.example.demo.model.Survey;
import com.example.demo.service.SurveyService1;
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
    private SurveyService1 surveyService1;

    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        return ResponseEntity.ok().body(surveyService1.getAllSurvey());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(surveyService1.getSurveyById(id));
    }

    @PostMapping
    public ResponseEntity<Survey> createSurvey (@RequestBody Survey survey) {
        return ResponseEntity.ok().body(surveyService1.createSurvey(survey));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Survey survey) {
        return ResponseEntity.ok().body(surveyService1.updateSurvey(id, survey));
    }

    @DeleteMapping(path = "{id}")
    public HttpStatus deleteSurveyById(@PathVariable("id") UUID id) {
        surveyService1.deleteSurvey(id);
        return HttpStatus.OK;
    }
}
