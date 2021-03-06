package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name="QUESTION")
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private long id;

    private String questionText;

    private boolean required;

    private String customAnswer;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "done_survey_id")
    private DoneSurvey doneSurvey;

    @ManyToMany(mappedBy = "questionSet")
    private Set<PossibleAnswer> possibleAnswerSet = new HashSet<>();

    public Question() {
    }

    public Question(@JsonProperty("id") long id,
                    @JsonProperty("questionText") String questionText,
                    @JsonProperty("required") boolean required,
                    @JsonProperty("customAnswer") String customAnswer) {
        this.id = id;
        this.questionText = questionText;
        this.required = required;
        this.customAnswer = customAnswer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getCustomAnswer() {
        return customAnswer;
    }

    public void setCustomAnswer(String customAnswer) {
        this.customAnswer = customAnswer;
    }

    public Set<PossibleAnswer> getPossibleAnswerSet() {
        return possibleAnswerSet;
    }

    public void setPossibleAnswerSet(Set<PossibleAnswer> possibleAnswerSet) {
        this.possibleAnswerSet = possibleAnswerSet;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public void addPossibleAnswer(PossibleAnswer possibleAnswer){
        possibleAnswerSet.add(possibleAnswer);
    }

//    public DoneSurvey getDoneSurvey() {
//        return doneSurvey;
//    }

    public void setDoneSurvey(DoneSurvey doneSurvey) {
        this.doneSurvey = doneSurvey;
    }
}
