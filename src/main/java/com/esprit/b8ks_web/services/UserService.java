package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.User;
import com.esprit.b8ks_web.repository.RoleRepo;
import com.esprit.b8ks_web.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.management.relation.Role;
import java.util.List;

@Service
public class UserService implements IService<User> {

    @Autowired
   private UserRepo userRepo;


BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public void add(User p) {
p.setPassword(encoder.encode(p.getPassword()));
       userRepo.save(p);
    }

    @Override
    public List<User> getList() {
        return userRepo.findAll();
    }

    @Override
    public void delete(long p) {
userRepo.deleteById(p);
    }

    @Override
    public User modify(User p) {

        return userRepo.save(p);
    }

    @Override
    public User findById(long id) {
        System.out.println("mchtttttt===="+userRepo.findById(id).get());
        return userRepo.getOne(id);
    }

    @Override
    public User findByEmail(String e) {

        return userRepo.findUsersByEmail(e);
    }

    @Override
    public List<User> findUsersByRole(String e) {
      return   userRepo.findUsersByRoles(e);
    }
}
