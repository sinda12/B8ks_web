package com.esprit.b8ks_web.services.implementation;

import com.esprit.b8ks_web.entities.Comment;
import com.esprit.b8ks_web.repository.CommentRepository;
import com.esprit.b8ks_web.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService implements ICommentService {

    @Autowired
    CommentRepository commentRepository;
    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}