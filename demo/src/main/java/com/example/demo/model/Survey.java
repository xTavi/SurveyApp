package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;


public class Survey {
    private final UUID id;

    @NotBlank
    private final String title;
//    Here should be some questions
    private final boolean open;

    public Survey(@JsonProperty("id") UUID id,
                  @JsonProperty("title") String title,
                  @JsonProperty("open") boolean open) {
        this.id = id;
        this.title = title;
        this.open = open;
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
}
