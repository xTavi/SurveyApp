package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;


public class Survey {

    private final UUID id;

    @NotBlank
    private final String title;

    private final boolean open;

    private final List<Question> questionList;

    public Survey(@JsonProperty("id") UUID id,
                  @JsonProperty("title") String title,
                  @JsonProperty("open") boolean open,
                  @JsonProperty("questionList") List<Question> questionList) {
        this.id = id;
        this.title = title;
        this.open = open;
        this.questionList = questionList;
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
