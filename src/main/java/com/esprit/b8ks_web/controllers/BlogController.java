package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Blog;
import com.esprit.b8ks_web.services.IBlogService;
import com.esprit.b8ks_web.services.implementation.CursefilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        CursefilterService.loadConfigs();
        ArrayList<String > badwords =  CursefilterService.badWordsFound(blog.getText());
        String text = blog.getText();
       blog.setText(blog.getText().replaceAll("1","i"));
       blog.setText(blog.getText().replaceAll("!","i"));
       blog.setText(blog.getText().replaceAll("3","e"));
       blog.setText(blog.getText().replaceAll("4","a"));
       blog.setText(blog.getText().replaceAll("@","a"));
       blog.setText(blog.getText().replaceAll("5","s"));
       blog.setText(blog.getText().replaceAll("7","t"));
       blog.setText(blog.getText().replaceAll("0","o"));
       blog.setText(blog.getText().replaceAll("9","g"));
       blog.setText(blog.getText().replaceAll("\\$","s"));
        badwords.forEach(bw -> {
            StringBuilder sb = new StringBuilder();
            for(int c = 0; c<bw.length(); c++){
                sb.append("*");
            }

            blog.setText(blog.getText().replace(bw, sb.toString()));
        });
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
