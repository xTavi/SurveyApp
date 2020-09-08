package com.example.demo;

import com.example.demo.model.PossibleAnswer;
import com.example.demo.model.Question;
import com.example.demo.model.Survey;
import com.example.demo.repositories.AnswerRepository;
import com.example.demo.repositories.QuestionRepository;
import com.example.demo.repositories.SurveyRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class SurveyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(QuestionRepository questionRepository, AnswerRepository answerRepository, SurveyRepository surveyRepository){
		Faker faker = new Faker();
		return args -> {
			Survey survey1 = new Survey();
			survey1.setTitle("Cel mai tare chestionar");
			survey1.setOpen(true);
			surveyRepository.save(survey1);

			Question question1 = new Question(1, "What is your name", false, "");
			question1.setSurvey(survey1);
			questionRepository.save(question1);

			PossibleAnswer possibleAnswer1 = new PossibleAnswer(1, "Answer1", new HashSet<>());
			possibleAnswer1.addQuestion(question1);
			answerRepository.save(possibleAnswer1);

		};
	}
}

