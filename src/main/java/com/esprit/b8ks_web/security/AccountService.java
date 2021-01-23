package com.esprit.b8ks_web.security;

import com.esprit.b8ks_web.entities.Role;
import com.esprit.b8ks_web.entities.User;

public interface AccountService {
    public User saveUser (User user) ;
    public Role saveRole (Role role) ;
    public    User loadUserByEmail ( String email) ;
    public   void addRoleToUser (String Email , String roleName) ;
}
