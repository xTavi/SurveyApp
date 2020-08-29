package com.example.demo.model;

import javax.persistence.*;

@Entity(name = "ANSWER")
public class Answer {

    @Id
    @GeneratedValue
    private long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;


    public Answer() {
    }

    public Answer(long id, String text, Question question) {
        this.id = id;
        this.text = text;
        this.question = question;
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
}
