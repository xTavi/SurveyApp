package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Entity(name="SURVEY")
public class Survey {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private  String title;

    private  boolean open;

    @OneToMany(mappedBy = "survey")
    private  List<Question> questionList;


    public Survey(@JsonProperty("id") UUID id,
                  @JsonProperty("title") String title,
                  @JsonProperty("open") boolean open,
                  @JsonProperty("questionList") List<Question> questionList) {
        this.id = id;
        this.title = title;
        this.open = open;
        this.questionList = questionList;
    }

    public Survey(){

    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isOpen() {
        return open;
    }

    public List<Question> getQuestionList() { return questionList; }
}
