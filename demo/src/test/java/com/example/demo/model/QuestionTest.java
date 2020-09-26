package com.example.demo.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
public class QuestionTest {

    @Test
    void groupAssertion() {
        Question question = new Question(1,
                "What are you doing today?",
                true,
                "Here is nothing");

        assertAll("Test for question properties",
                () -> assertEquals(question.getId(), 1, "Failed id"),
                () -> assertEquals(question.getQuestionText(), "What are you doing today?", "Failed text"),
                () -> assertTrue(question.isRequired(), "Failed true"),
                () -> assertEquals(question.getCustomAnswer(), "Here is nothing", "Failed custom answer"));
    }

}
