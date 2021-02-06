package com.esprit.b8ks_web.repository;

import com.esprit.b8ks_web.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}