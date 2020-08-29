package com.example.demo.controllers;
import com.example.demo.model.Answer;
import com.example.demo.service.AnswerService;
import com.example.demo.service.QuestionService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("api/v1/answer")
@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping()
    public ResponseEntity<List<Answer>> getAllAnswers(){
        return ResponseEntity.ok().body(answerService.getAllAnswer());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable long id){
        return ResponseEntity.ok().body(answerService.getAnswerById(id));
    }

    @PostMapping()
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer){
        return ResponseEntity.ok().body(answerService.createAnswer(answer));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable long id, @RequestBody Answer answer){
        return ResponseEntity.ok().body(this.answerService.updateAnswer(id, answer));
    }

    @DeleteMapping(path = "{id}")
    public HttpStatus deleteAnswer(@PathVariable long id){
        this.answerService.deleteAnswer(id);
        return HttpStatus.OK;
    }

}
