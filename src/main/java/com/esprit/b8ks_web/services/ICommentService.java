package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommentService {
    public Comment save(Comment comment);
    public Comment findById(Long id);
    public List<Comment> findAll();
    public void deleteById(Long id);
}