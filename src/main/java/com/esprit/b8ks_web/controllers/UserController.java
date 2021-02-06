package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.User;
import com.esprit.b8ks_web.security.AccountService;
import com.esprit.b8ks_web.services.IService;
import com.esprit.b8ks_web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest/user/")

public class UserController implements IService<User> {

@Autowired
private AccountService accountServiceImpl ;
    @Autowired
 private    UserService userController;



    @PostMapping("register/")
    @Override
    public void add(@RequestBody User p) {
    accountServiceImpl.saveUser(p);
    }


@GetMapping("list/")
    @Override
    public List<User> getList() {
        return userController.getList();
    }



@DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable long id) {
userController.delete(id);
    }


@PutMapping
    @Override
    public User modify(@RequestBody User p) {
        return userController.modify(p);
    }



@GetMapping("{id}")
    @Override
    public User findById(@PathVariable long id) {
        System.out.println("mchtttttt===="+id);
    return userController.findById(id);
    }
    @GetMapping("mail/")
    @Override
    public User findByEmail(@RequestParam String E) {
       return userController.findByEmail(E);
    }
    @GetMapping("role/")
    @Override
    public List<User> findUsersByRole(@RequestParam String E) {
        return userController.findUsersByRole(E);
    }
}
