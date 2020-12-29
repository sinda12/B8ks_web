package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    public Blog save(Blog blog);
    public Blog findById(Long id);
    public List<Blog> findAll();
    public void deleteById(Long id);
}
