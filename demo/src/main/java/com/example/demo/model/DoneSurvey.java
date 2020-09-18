package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Entity(name = "DONE_SURVEY")
public class DoneSurvey extends Survey {
    @Id
    @GeneratedValue
    private UUID id;

    private String respondentName;

    @OneToMany(mappedBy = "done_survey")
    private Set<Question> questionList;

    public DoneSurvey() {
    }

    public DoneSurvey(Survey survey){
        super(survey);
    }

    public DoneSurvey(@JsonProperty("id") UUID id,
                      @JsonProperty("respondentName") String respondentName) {
        this.id = id;
        this.respondentName = respondentName;
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

    public void setQuestionList(Set<Question> questionList) {
        this.questionList = questionList;
    }

}
