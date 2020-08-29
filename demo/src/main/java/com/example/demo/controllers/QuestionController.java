package com.example.demo.controllers;

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/v1/question")
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public void addSurvey(@Valid @NotNull @RequestBody Question question) {
        questionService.addQuestion(question);
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

//    @GetMapping(path = "{id}")
//    public Survey getSurveyById(@PathVariable("id") UUID id){
//        return surveyService.getSurveyById(id).orElse(null);
//    }
//
//    @DeleteMapping(path = "{id}")
//    public void deleteSurveyById(@PathVariable("id") UUID id) {  surveyService.deleteSurvey(id); }
//
//    @PutMapping(path = "{id}")
//    public void updateSurvey(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Survey surveyToUpdate) {
//        surveyService.updateSurvey(id, surveyToUpdate);
//    }
}
