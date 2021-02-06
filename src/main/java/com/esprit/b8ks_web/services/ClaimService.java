package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Claim;
import com.esprit.b8ks_web.entities.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClaimService {
    public Claim save(Claim claim);
    public Claim findById(Long id);
    public List<Claim> findAll();
    public void deleteById(Long id);
    public List<Object[]> countTotalClaimsByDate();
}