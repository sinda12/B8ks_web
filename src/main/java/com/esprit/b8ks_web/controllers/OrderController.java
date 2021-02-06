package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Order;
import com.esprit.b8ks_web.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/order")
public class OrderController {

    final IOrderService orderService;


    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Order order){
        if(order.getId() == null){
            Optional<Order> order1 = Optional.of(orderService.save(order));
            return ResponseEntity.created(null).body(order1);
        }
        return ResponseEntity.badRequest().build();

    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Order order){
        if(order.getId() != null){
            Order order1 = orderService.save(order);
            return ResponseEntity.accepted().body(order1);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}