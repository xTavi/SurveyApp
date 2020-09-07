package com.example.demo.controllers;
import com.example.demo.model.Question;
import com.example.demo.service.QuestionService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("api/v1/question")
@RestController
public class QuestionController {

    @Autowired
    private QuestionService1 questionService;

    @GetMapping()
    public ResponseEntity<List<Question>> getAllQuestions(){
        return ResponseEntity.ok().body(questionService.getAllQuestion());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable long id){
        return ResponseEntity.ok().body(questionService.getQuestionById(id));
    }

    @PostMapping()
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        return ResponseEntity.ok().body(questionService.createQuestion(question));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable long id, @RequestBody Question question){
        return ResponseEntity.ok().body(this.questionService.updateQuestion(id, question));
    }

    @DeleteMapping(path = "{id}")
    public HttpStatus deleteQuestion(@PathVariable long id) {
        this.questionService.deleteQuestion(id);
        return HttpStatus.OK;
    }

}
