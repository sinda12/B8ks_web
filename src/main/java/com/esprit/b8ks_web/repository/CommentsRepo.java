package com.esprit.b8ks_web.repository;


import com.esprit.b8ks_web.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CommentsRepo extends JpaRepository<Comments, Long> {
    @Query("SELECT c.text, c.date FROM Comments AS c  ORDER BY c.date DESC")
    List<Object[]> countTotalCommentsByYear();

  /*  @Query("SELECT b,c.text,c.date, c.username FROM BOOK as b AND Comments as c WHERE c.bookid = b.id ORDER BY c.date DESC")
    List<Object[]> showCommentsforBooks();*/


}