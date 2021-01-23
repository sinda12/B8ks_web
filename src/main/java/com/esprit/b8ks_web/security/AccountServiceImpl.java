package com.esprit.b8ks_web.security;

import com.esprit.b8ks_web.entities.Role;
import com.esprit.b8ks_web.entities.User;
import com.esprit.b8ks_web.repository.RoleRepo;
import com.esprit.b8ks_web.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserRepo userRepository ;
    @Autowired
    private RoleRepo roleRepository ;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder ;

    @Override
    public User saveUser(User user) {
        System.out.println("lowww");
        User us = userRepository.findUsersByEmail(user.getEmail());
        System.out.println("lowwweeellll");
        if(us!=null) throw new RuntimeException("User already exist");
        System.out.println("theeeniiiii");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println("theeeleethhhh");
        userRepository.save(user);
        System.out.println("eeraaabaaaaaa");
        addRoleToUser(user.getEmail(),"USER");
        return user ;

    }

    @Override
    public Role saveRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User loadUserByEmail(String email) {

        return userRepository.findUsersByEmail(email);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        User user = userRepository.findUsersByEmail(email);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);

    }
}
