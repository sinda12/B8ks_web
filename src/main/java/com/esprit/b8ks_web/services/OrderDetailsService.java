package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.OrderDetails;
import com.esprit.b8ks_web.entities.OrderDetailsPK;
import com.esprit.b8ks_web.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService implements IOrderDetailsService {


    @Autowired
    private OrderDetailsRepository orderDetailsRepository;



    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }


    @Override
    public OrderDetails findById(OrderDetailsPK id) {
        return  orderDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public void deleteById(OrderDetailsPK id) {
        orderDetailsRepository.deleteById(id);

    }



}