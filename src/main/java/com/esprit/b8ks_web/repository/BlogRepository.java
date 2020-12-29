package com.esprit.b8ks_web.repository;

import com.esprit.b8ks_web.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
