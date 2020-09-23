package com.example.demo.service;

import com.example.demo.model.DoneSurvey;

import java.util.List;
import java.util.UUID;

public interface DoneSurveyService {

    DoneSurvey createDoneSurvey(DoneSurvey doneSurvey);
    DoneSurvey getDoneSurveyById(UUID id);
    List<DoneSurvey> getAllDoneSurvey();

}
