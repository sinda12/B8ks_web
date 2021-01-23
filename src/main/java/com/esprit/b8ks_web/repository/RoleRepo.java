package com.esprit.b8ks_web.repository;

import com.esprit.b8ks_web.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRoleName (String name);
}
