package com.example.demo.controllers;
import com.example.demo.model.PossibleAnswer;
import com.example.demo.service.AnswerService;
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
    public ResponseEntity<List<PossibleAnswer>> getAllAnswers(){
        return ResponseEntity.ok().body(answerService.getAllAnswer());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<PossibleAnswer> getAnswerById(@PathVariable long id){
        return ResponseEntity.ok().body(answerService.getAnswerById(id));
    }

    @PostMapping()
    public ResponseEntity<PossibleAnswer> createAnswer(@RequestBody PossibleAnswer possibleAnswer){
        return ResponseEntity.ok().body(answerService.createAnswer(possibleAnswer));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<PossibleAnswer> updateAnswer(@PathVariable long id, @RequestBody PossibleAnswer possibleAnswer){
        return ResponseEntity.ok().body(this.answerService.updateAnswer(id, possibleAnswer));
    }

    @DeleteMapping(path = "{id}")
    public HttpStatus deleteAnswer(@PathVariable long id){
        this.answerService.deleteAnswer(id);
        return HttpStatus.OK;
    }

}
