package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "POSSIBLE_ANSWER")
public class PossibleAnswer {

    @Id
    @GeneratedValue
    private long id;
    private String text;


    @ManyToMany
    @JoinTable(
            name = "questions_possible_answers",
            joinColumns = @JoinColumn(name = "possible_answer_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private Set<Question> questionSet;


    public PossibleAnswer() {
    }

    public PossibleAnswer(@JsonProperty("id") long id,
                          @JsonProperty("text") String text,
                          @JsonProperty("question") Set<Question> questionSet) {
        this.id = id;
        this.text = text;
        this.questionSet = questionSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public Set<Question> getQuestionSet() {
//        return questionSet;
//    }

    public void setQuestionSet(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }
}
