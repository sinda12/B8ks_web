package com.esprit.b8ks_web.controllers;


import com.esprit.b8ks_web.entities.OrderDetails;
import com.esprit.b8ks_web.entities.OrderDetailsPK;
import com.esprit.b8ks_web.services.OrderDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/order-details")
public class OrderDetailsController {

    final OrderDetailsService orderDetailsService;


    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(orderDetailsService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody OrderDetails orderDetails){
        if(orderDetails.getOrderDetailsPK() == null){
            Optional<OrderDetails> orderDetails1 = Optional.of(orderDetailsService.save(orderDetails));
            return ResponseEntity.created(null).body(orderDetails1);
        }
        return ResponseEntity.badRequest().build();

    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody OrderDetails orderDetails){
        if(orderDetails.getOrderDetailsPK() != null){
            OrderDetails orderDetails1 = orderDetailsService.save(orderDetails);
            return ResponseEntity.accepted().body(orderDetails1);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{oid}/{}")
    public ResponseEntity<?> delete(@PathVariable("id") OrderDetailsPK id){
        orderDetailsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}