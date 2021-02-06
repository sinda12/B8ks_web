package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Comment;
import com.esprit.b8ks_web.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    ICommentService commentService;

    @GetMapping
    public List<Comment> findAll(){
        return commentService.findAll();
    }
    @PostMapping
    public Comment save(@RequestBody Comment comment){
        return commentService.save(comment);
    }

    @PutMapping
    public Comment update(@RequestBody Comment comment){
        return commentService.save(comment);
    }

    @GetMapping("{id}")
    public Comment findById(@PathVariable("id") Long id){
        return commentService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id){
        commentService.deleteById(id);
    }


}