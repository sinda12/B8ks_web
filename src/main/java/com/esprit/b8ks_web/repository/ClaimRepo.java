package com.esprit.b8ks_web.repository;


import com.esprit.b8ks_web.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimRepo extends JpaRepository<Claim, Long> {
    @Query("SELECT c.text, c.date FROM Claim c  ORDER BY c.date DESC")
    public List<Object[]> countTotalClaimsByDate();


}