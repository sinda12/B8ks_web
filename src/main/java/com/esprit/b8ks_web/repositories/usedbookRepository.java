package com.esprit.b8ks_web.repositories;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.esprit.b8ks_web.entities.usedbook;

@Repository
public interface usedbookRepository extends JpaRepository<usedbook, Integer> {
	usedbook findByLabel ( String label);

	@Query("SELECT B from usedbook B WHERE B.label LIKE %?1%")
	public List<usedbook> searchBooksByLabel(String keyword);
		
	
	
	@Query("SELECT DISTINCT C.totalPrice from usedbook C join  CI join CI.usedbook B where B.id=?1")
	public double getTotalPrixByUsedbook(int usedbookId);
	
	@Query("SELECT B from usedbook B join B.cartItem CI where CI.quantity is (SELECT MAX(CI.quantity) as maximum from CI group by CI.usedbook)")
	public usedbook getMostSelectedBook();
	
	@Query("SELECT B from Book B join B.cartItem CI join CI.cart C join C.customer CU where CU.id=?1 and CI.quantity in (SELECT quantity from CI ORDER BY quantity)")
	public List<usedbook> getMostSelectedBooksByCustomer(Long customerId);
}


