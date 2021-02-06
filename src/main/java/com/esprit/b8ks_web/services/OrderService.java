package com.esprit.b8ks_web.services;


import com.esprit.b8ks_web.entities.Order;
import com.esprit.b8ks_web.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {


    @Autowired
    private OrderRepository orderRepository;



    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }


    @Override
    public Order findById(Long id) {
        return  orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);

    }



}