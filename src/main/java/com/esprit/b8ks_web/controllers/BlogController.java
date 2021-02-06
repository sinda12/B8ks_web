package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Blog;
import com.esprit.b8ks_web.services.IBlogService;
import com.esprit.b8ks_web.services.implementation.CursefilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
//        CursefilterService.filterText(blog.getText(),"");

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

    @GetMapping("report/{id}")
    public Blog report(@PathVariable Long id){
        Blog b = blogService.findById(id);
        b.setReport(b.getReport() + 1);
        return blogService.save(b);
    }
}
