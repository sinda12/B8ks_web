package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IOrderService {
    public Order save(Order order);
    public Order findById(Long id);
    public List<Order> findAll();
    public void deleteById(Long id);
}
