package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "DONE_SURVEY")
public class DoneSurvey {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    private String creatorName;

    private String respondentName;

    private String questionText;

    private String givenAnswer;


    public DoneSurvey() {
    }

    public DoneSurvey(@JsonProperty("id") UUID id,
                      @JsonProperty("title") String title,
                      @JsonProperty("creatorName") String creatorName,
                      @JsonProperty("respondentName") String respondentName,
                      @JsonProperty("questionText") String questionText,
                      @JsonProperty("givenAnswer") String givenAnswer) {
        this.id = id;
        this.title = title;
        this.creatorName = creatorName;
        this.respondentName = respondentName;
        this.questionText = questionText;
        this.givenAnswer = givenAnswer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRespondentName() {
        return respondentName;
    }

    public void setRespondentName(String respondentName) {
        this.respondentName = respondentName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getGivenAnswer() {
        return givenAnswer;
    }

    public void setGivenAnswer(String givenAnswer) {
        this.givenAnswer = givenAnswer;
    }
}
