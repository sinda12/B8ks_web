package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Claim;
import com.esprit.b8ks_web.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/claims")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @GetMapping("/getclaims")
    public List<Claim> findAll() {
        return claimService.findAll();
    }

    @PostMapping("/saveclaims")
    public Claim save(@RequestBody Claim claim) {
        return claimService.save(claim);
    }

    @PutMapping("/updateclaims")
    public Claim update(@RequestBody Claim claim) {
        return claimService.save(claim);
    }

    @GetMapping("/getclaimsid/{id}")
    public Claim findById(@PathVariable("id") Long id) {
        return claimService.findById(id);
    }

    @DeleteMapping("/deleteclaims/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        claimService.deleteById(id);
    }

   @GetMapping("/getclaimsbydate")
    public List<Object[]> countTotalCommentsByYear() {
        return claimService.countTotalClaimsByDate();

    }

    @GetMapping("/getclaimsbystatushigh")
    public List<Object[]> countTotalClaimsByStatusHigh(){
        return claimService.countTotalClaimsByStatusHigh();
    };

    @GetMapping("/getclaimsbystatusmedium")
    public List<Object[]> countTotalClaimsByStatusMedium(){
        return claimService.countTotalClaimsByStatusMedium();
    };

    @GetMapping("/getclaimsbystatuslow")
    public List<Object[]> countTotalClaimsByStatusLow(){
        return claimService.countTotalClaimsByStatusLow();
    };
}
