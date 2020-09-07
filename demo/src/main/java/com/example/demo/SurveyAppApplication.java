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
			Survey survey = new Survey();
			survey.setTitle("Cel mai tare chestionar");
			survey.setOpen(true);


			PossibleAnswer fakePossibleAnswer = new PossibleAnswer(1, "Answer1", new HashSet<>());
			Set<PossibleAnswer> possibleAnswerSet = new HashSet<>();
			possibleAnswerSet.add(fakePossibleAnswer);
			answerRepository.save(fakePossibleAnswer);

			Question q1 = new Question(1, "What is your name", false, "", possibleAnswerSet);
			Set<Question> questionSet = new HashSet<>();
			questionSet.add(q1);
			questionRepository.save(q1);

			List<Question> questionList = new ArrayList<>();
			questionList.add(q1);
			survey.setQuestionList(questionList);
			surveyRepository.save(survey);

//			for (int i = 0; i < 5; i++) {
//
//				questionRepository.save(new Question(i, faker.animal().name() + "?", false, faker.book().author(), possibleAnswerSet));
//				answerRepository.save(new PossibleAnswer(i, faker.dog().name(), questionSet));
//
//			}
		};
	}
}

