package com.example.demo;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repositories.AnswerRepository;
import com.example.demo.repositories.QuestionRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SurveyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(QuestionRepository questionRepository, AnswerRepository answerRepository){
		Faker faker = new Faker();
		return args -> {
			Question q1 = new Question(1, faker.animal().name(), false, faker.book().author());
			for(int i = 0; i < 5; i++){

				questionRepository.save(new Question(i, faker.animal().name(), false, faker.book().author()));
				answerRepository.save(new Answer(i, faker.dog().name(), q1));
			}

		};
	}
}
