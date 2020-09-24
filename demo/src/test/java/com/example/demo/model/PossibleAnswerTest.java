package com.example.demo.model;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("model")
public class PossibleAnswerTest {

    @Test
    void groupAssertion() {
        PossibleAnswer possibleAnswer = new PossibleAnswer(1, "I don't have an answer", new HashSet<>());

        assertAll("Test properties set",
                () -> assertEquals(possibleAnswer.getId(), 1, "Failed id"),
                () -> assertEquals(possibleAnswer.getText(), "I don't have an answer", "Failed text")
        );
    }
}