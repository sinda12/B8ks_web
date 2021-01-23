package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.User;
import com.esprit.b8ks_web.security.AccountServiceImpl;
import com.esprit.b8ks_web.services.IService;
import com.esprit.b8ks_web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest/")

public class UserController implements IService<User> {


    AccountServiceImpl userController1 = new AccountServiceImpl() ;
    @Autowired
    UserService userController;



@PostMapping
    @Override
    public void add(@RequestBody User p) {
userController1.saveUser(p);
    }


@GetMapping
    @Override
    public List<User> getList() {
        return userController.getList();
    }



@DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable int id) {
userController.delete(id);
    }


@PutMapping
    @Override
    public User modify(@RequestParam("p") User p) {
        return userController.modify(p);
    }



@GetMapping("{id}")
    @Override
    public User findById(@PathVariable int id) {
        System.out.println("mchtttttt===="+id);
    return userController.findById(id);
    }

    @Override
    public User findByEmail(String E) {
        return null;
    }
}
