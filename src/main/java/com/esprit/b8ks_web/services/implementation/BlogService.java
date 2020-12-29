package com.esprit.b8ks_web.services.implementation;

import com.esprit.b8ks_web.entities.Blog;
import com.esprit.b8ks_web.repository.BlogRepository;
import com.esprit.b8ks_web.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }
}
