package com.esprit.b8ks_web.repository;

import com.esprit.b8ks_web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findUsersByEmail (String email);
    @Query(value = "SELECT u.* FROM `user` u,`user_roles` ur,`role` r WHERE r.id=ur.roles_id and ur.user_id=u.id and r.role_name = ?", nativeQuery = true)
    List<User> findUsersByRoles(String type);
}
