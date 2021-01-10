package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Cart;
import com.esprit.b8ks_web.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("api/catrs")
public class CartController {

    int u=5;

    @Autowired
    CartService cartService;

    @GetMapping("/listCart")
    public List<Cart> findAll(){
       return cartService.findALL();
   }

    @GetMapping("/listCartUser/{u}")
    public List<Cart> userCart(@PathVariable int u){
        return cartService.userCart(u);
    }


    @PostMapping("/addToCart")
    public Cart addToCart(@RequestBody Cart c) {
        return  cartService.addCart(c);
    }
    @DeleteMapping("/deleteCarts")
    public String deleteCart() {
        return cartService.deleteCarts();

    }
    @DeleteMapping("/deleteCart_id/{id}")
    public String deleteCart(@PathVariable int id) {
        return cartService.deleteCart(id);

    }

    @PutMapping("/quantityP/{b}")
    public void quantityP(@PathVariable int b){
        cartService.quantityP(u,b);
    }
    @PutMapping("/quantityM/{b}")
    public void quantityM(@PathVariable int b){
        cartService.quantityM(u,b);
    }


}
