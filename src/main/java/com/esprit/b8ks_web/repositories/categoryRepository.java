package com.esprit.b8ks_web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.esprit.b8ks_web.entities.category;


public interface categoryRepository extends JpaRepository<category, Integer> {
	category findByTitre(String title);
	
	@Query("SELECT C from Category C join C.usedbook B B.cartItem CI where CI.quantity is (SELECT MAX(CI.quantity) as maximum from CI group by CI.usedbook)")
	public category getMostSelectedCategory();


}
