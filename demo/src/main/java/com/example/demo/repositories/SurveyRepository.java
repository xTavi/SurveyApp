package com.example.demo.repositories;

import com.example.demo.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public interface SurveyRepository extends JpaRepository<Survey, UUID> {
    List<Survey> findByCreatorName(String creatorName);
}
