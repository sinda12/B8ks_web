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
public interface CartRepository extends CrudRepository<Cart,Integer>,JpaRepository<Cart,Integer> {


    @Query("SELECT C from Cart C WHERE C.user.id=?1 ")
    public List<Cart> userCart(int user_id);

    public List<Cart> findAllByUser_Id(int user_id);
    @Modifying
    @Transactional
    @Query("UPDATE Cart C SET C.quantity=(C.quantity+1) where C.user.id=?1 and C.book.id=?2")
    public void quantityP(int u,int b);

    @Modifying
    @Transactional
    @Query("UPDATE Cart C SET C.quantity=(C.quantity-1) where C.user.id=?1 and C.book.id=?2")
    public void quantityM(int u,int b);

    @Query("SELECT SUM(C.quantity) FROM Cart C where C.user.id=?1")
    Float TotalCart(int u);





}