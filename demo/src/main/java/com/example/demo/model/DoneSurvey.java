package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "DONE_SURVEY")
public class DoneSurvey extends Survey {
    @Id
    @GeneratedValue
    private long id;

    private String respondentName;

    public DoneSurvey() {
    }

    public DoneSurvey(@JsonProperty("id") long id,
                      @JsonProperty("respondentName") String respondentName) {
        this.id = id;
        this.respondentName = respondentName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRespondentName() {
        return respondentName;
    }

    public void setRespondentName(String respondentName) {
        this.respondentName = respondentName;
    }

}
