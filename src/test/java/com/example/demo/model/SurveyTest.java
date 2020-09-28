package com.example.demo.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
public class SurveyTest {

    @Test
    void groupAssertions() {
        UUID surveyId = UUID.randomUUID();
        Survey survey = new Survey(surveyId,
                "Title",
                "Tavi",
                true, new HashSet<>());

        Question question = new Question(1,
                "What are you doing today?",
                true,
                "Here is nothing");

        survey.getQuestionList().add(question);

        assertAll("Testing Survey properties",
                () -> assertEquals(survey.getId(), surveyId, "Failed Id"),
                () -> assertEquals(survey.getTitle(), "Title", "Failed Title"),
                () -> assertEquals(survey.getCreatorName(), "Tavi", "Failed creator name"),
                () -> assertTrue(survey.isOpen(), "Failed open"),
                () -> assertEquals(survey.getQuestionList().stream().findFirst().get(), question, "Failed first question"));
    }
}