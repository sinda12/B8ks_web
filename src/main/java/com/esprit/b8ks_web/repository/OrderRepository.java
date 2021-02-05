package com.esprit.b8ks_web.repository;


import com.esprit.b8ks_web.entities.Book;
import com.esprit.b8ks_web.entities.Cart;
import com.esprit.b8ks_web.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends  JpaRepository<Order,Long> {

    @Query(nativeQuery=true, value="SELECT B  FROM book B ORDER BY random() LIMIT 3")
    public List<Book> userCart(int user_id);
}
