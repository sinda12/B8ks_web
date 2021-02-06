package com.esprit.b8ks_web.repository;

import com.esprit.b8ks_web.entities.OrderDetails;
import com.esprit.b8ks_web.entities.OrderDetailsPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsPK> {
}