package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Blog;
import com.esprit.b8ks_web.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blogs")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping
    public List<Blog> findAll(){
        return blogService.findAll();
    }
    @PostMapping
    public Blog save(@RequestBody Blog blog){
        return blogService.save(blog);
    }

    @PutMapping
    public Blog update(@RequestBody Blog blog){
        return blogService.save(blog);
    }

    @GetMapping("{id}")
    public Blog findById(@PathVariable("id") Long id){
        return blogService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id){
        blogService.deleteById(id);
    }

}
