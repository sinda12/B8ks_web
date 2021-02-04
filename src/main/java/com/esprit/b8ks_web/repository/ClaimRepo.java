package com.esprit.b8ks_web.repository;


import com.esprit.b8ks_web.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepo extends JpaRepository<Claim, Long> {

}