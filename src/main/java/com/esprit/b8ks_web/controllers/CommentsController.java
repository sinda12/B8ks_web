package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Comments;
import com.esprit.b8ks_web.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @GetMapping("/getcomments")
    public List<Comments> findAll() {
        return commentsService.findAll();
    }

    @PostMapping("/savecomments")
    public Comments save(@RequestBody Comments comment) {
        return commentsService.save(comment);
    }

    @PutMapping("/updatecomments")
    public Comments update(@RequestBody Comments comment) {
        return commentsService.save(comment);
    }

    @GetMapping("/getcommentsid/{id}")
    public Comments findById(@PathVariable("id") Long id) {
        return commentsService.findById(id);
    }

    @DeleteMapping("/deletecomments/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        commentsService.deleteById(id);
    }

    @GetMapping("/getcommentsbydate")
    public List<Object[]> countTotalCommentsByYear() {
        return commentsService.countTotalCommentsByYear();
    }

   /* @GetMapping("/getcommentsbybook")
    public List<Object[]> showCommentsforBooks() {
        return commentsService.showCommentsforBooks();
    }*/

    @GetMapping("/getcommentsbyrate")
    public List<Object[]> OrderTotalCommentsByRate() {
        return commentsService.orderTotalCommentsByRate();
    }



}
