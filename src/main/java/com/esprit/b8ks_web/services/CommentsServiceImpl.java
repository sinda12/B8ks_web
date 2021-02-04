package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Comments;
import com.esprit.b8ks_web.repository.CommentsRepo;
import com.esprit.b8ks_web.services.CommentsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    CommentsRepo commentsRepo;
    @Override
    public Comments save(Comments comment) {
        return commentsRepo.save(comment);
    }

    @Override
    public Comments findById(Long id) {
        return commentsRepo.findById(id).orElse(null);
    }

    @Override
    public List<Comments> findAll() {
        return commentsRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        commentsRepo.deleteById(id);
    }

    @Override
    public List<Object[]> countTotalCommentsByYear() { return commentsRepo.countTotalCommentsByYear(); }

    /*@Override
    public List<Object[]> showCommentsforBooks() { return commentsRepo.showCommentsforBooks(); }*/


}