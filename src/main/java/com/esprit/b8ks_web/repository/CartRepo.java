package com.esprit.b8ks_web.repository;

import com.esprit.b8ks_web.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepo extends CrudRepository<Cart,Integer>,JpaRepository<Cart,Integer> {

    @Query("SELECT C from Cart C WHERE C.user_id=?1")
    public List<Cart> userCart(int user_id);

    @Modifying
    @Transactional
    @Query("UPDATE Cart C SET C.quantity=(C.quantity+1) where C.user_id=?1 and C.book_id=?2")
    public void quantityP(int u,int b);

    @Modifying
    @Transactional
    @Query("UPDATE Cart C SET C.quantity=(C.quantity-1) where C.user_id=?1 and C.book_id=?2")
    public void quantityM(int u,int b);
}
