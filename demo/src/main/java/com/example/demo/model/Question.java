package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;


@Entity(name="QUESTION")
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private long id;

    private String questionText;

    private boolean required;

    private String customAnswer;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;

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
//        this.answerList = answerList;
    }

//    public Question(@JsonProperty("id")  long id,
//                    @JsonProperty("questionText")  questionText,
//                    @JsonProperty("required") required,
//                    @JsonProperty("customAnswer") customAnswer) {
//        this.id = id;
//        this.questionText = questionText;
//        this.required = required;
//        this.customAnswer = customAnswer;
////        this.answerList = answerList;
//    }


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
}
