package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name="SURVEY")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Survey {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String title;

    private boolean open;

    private String creatorName;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setQuestionList(Set<Question> questionList) {
        this.questionList = questionList;
    }

    @OneToMany(mappedBy = "survey")
    private Set<Question> questionList =  new HashSet<>();

    public Survey(){
    }

    public Survey(Survey survey){
        this.id = survey.getId();
        this.title = survey.getTitle();
        this.open = survey.isOpen();
        this.creatorName = survey.getCreatorName();
        this.questionList = survey.getQuestionList();
    }

    public Survey(@JsonProperty("id") UUID id,
                  @JsonProperty("title") String title,
                  @JsonProperty("creator_name") String creatorName,
                  @JsonProperty("open") boolean open,
                  @JsonProperty("questionList") Set<Question> questionList) {
        this.id = id;
        this.title = title;
        this.creatorName = creatorName;
        this.open = open;
        this.questionList = questionList;
    }


    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public boolean isOpen() {
        return open;
    }

    public Set<Question> getQuestionList() { return questionList; }
}
