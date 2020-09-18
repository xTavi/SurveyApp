package com.example.demo.controllers;

import com.example.demo.model.DoneSurvey;
import com.example.demo.service.DoneSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/done_survey")
@RestController
public class DoneSurveyController {

    @Autowired
    private DoneSurveyService doneSurveyService;

    @GetMapping
    public ResponseEntity<List<DoneSurvey>> getAllDoneSurveys() {
        return ResponseEntity.ok().body(doneSurveyService.getAllDoneSurvey());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<DoneSurvey> getDoneSurveyById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(doneSurveyService.getDoneSurveyById(id));
    }

    @PostMapping
    public ResponseEntity<DoneSurvey> createDoneSurvey (@RequestBody DoneSurvey doneSurvey) {

        return ResponseEntity.ok().body(doneSurveyService.createDoneSurvey(doneSurvey));
    }
}
