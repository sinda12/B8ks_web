package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentsService {
    public Comments save(Comments comment);
    public Comments findById(Long id);
    public List<Comments> findAll();
    public void deleteById(Long id);
    public List<Object[]> countTotalCommentsByYear();
   // public List<Object[]> showCommentsforBooks();
   public List<Object[]> orderTotalCommentsByRate();
}