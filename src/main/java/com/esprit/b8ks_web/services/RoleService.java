package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Role;
import com.esprit.b8ks_web.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IService<Role> {

    @Autowired
    private RoleRepo roleRepo ;
    @Override
    public void add(Role p) {
        roleRepo.save(p);
    }

    @Override
    public List<Role> getList() {
        return roleRepo.findAll();
    }

    @Override
    public void delete(long p) {
 roleRepo.deleteById(p);
    }

    @Override
    public Role modify(Role p) {
        return roleRepo.save(p);
    }

    @Override
    public Role findById(long id) {
        return roleRepo.findById(id).get();
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
