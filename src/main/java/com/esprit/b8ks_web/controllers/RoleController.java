package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Role;
import com.esprit.b8ks_web.services.IService;
import com.esprit.b8ks_web.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest/role")
public class RoleController implements IService<Role> {
    @Autowired
    private RoleService roleService ;


    @PostMapping("/add")
    @Override
    public void add(@RequestBody Role p) {
        roleService.add(p);
    }

    @Override
    public List<Role> getList() {
        return null;
    }

    @Override
    public void delete(long p) {

    }

    @Override
    public Role modify(Role p) {
        return null;
    }

    @Override
    public Role findById(long id) {
        return null;
    }

    @Override
    public Role findByEmail(String E) {
        return null;
    }

    @Override
    public List<Role> findUsersByRole(String E) {
        return null;
    }
}
