package com.example.demo.repositories;

import com.example.demo.model.PossibleAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository <PossibleAnswer, Long> {

}
