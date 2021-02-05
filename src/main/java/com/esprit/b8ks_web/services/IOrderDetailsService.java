package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Order;
import com.esprit.b8ks_web.entities.OrderDetails;
import com.esprit.b8ks_web.entities.OrderDetailsPK;

import java.util.List;

public interface IOrderDetailsService {
    public OrderDetails save(OrderDetails orderDetails);
    public OrderDetails findById(OrderDetailsPK id);
    public List<OrderDetails> findAll();
    public void deleteById(OrderDetailsPK id);
}
