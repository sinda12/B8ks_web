package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Cart;
import com.esprit.b8ks_web.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{


    @Autowired
    CartRepository cartRepository;


    @Override
    public Cart addCart(Cart c) {

        return cartRepository.save(c);
    }

    @Override
    public List<Cart> findALL() {
        return (List<Cart>) cartRepository.findAll();
    }

    @Override
    public String deleteCarts() {
        cartRepository.deleteAll();
        return "Empty cart";
    }

    @Override
    public String deleteCart(int id) {
        cartRepository.deleteById(id);
        return "cart " + id + " was deleted";
    }
    @Override
    public List<Cart> userCart(int user_id) {
        return cartRepository.findAllByUser_Id(user_id);
    }

    @Override
    public void quantityP(int u, int b) {
        cartRepository.quantityP(u,b);

    }

    @Override
    public void quantityM(int u, int b) {
        cartRepository.quantityM(u,b);

    }

    @Override
    public Float TotalCart(int u) {
        return cartRepository.TotalCart(u);
    }




}
