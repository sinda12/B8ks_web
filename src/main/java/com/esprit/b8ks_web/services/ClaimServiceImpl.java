package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Claim;
import com.esprit.b8ks_web.repository.ClaimRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    ClaimRepo claimRepo;
    @Override
    public Claim save(Claim claim) {
        return claimRepo.save(claim);
    }

    @Override
    public Claim findById(Long id) {
        return claimRepo.findById(id).orElse(null);
    }

    @Override
    public List<Claim> findAll() {
        return claimRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        claimRepo.deleteById(id);
    }
}