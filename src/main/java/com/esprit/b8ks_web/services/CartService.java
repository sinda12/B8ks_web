package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Cart;
import com.esprit.b8ks_web.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{


    @Autowired
    CartRepo cartRepo;


    @Override
    public Cart addCart(Cart c) {
        return cartRepo.save(c);
    }

    @Override
    public List<Cart> findALL() {
        return (List<Cart>) cartRepo.findAll();
    }

    @Override
    public String deleteCarts() {
        cartRepo.deleteAll();
        return "Empty cart";
    }

    @Override
    public String deleteCart(int id) {
        cartRepo.deleteById(id);
        return "cart " + id + " was deleted";
    }
    @Override
    public List<Cart> userCart(int user_id) {
        return cartRepo.userCart(user_id);
    }

    @Override
    public void quantityP(int u, int b) {
        cartRepo.quantityP(u,b);

    }

    @Override
    public void quantityM(int u, int b) {
        cartRepo.quantityM(u,b);

    }

    @Override
    public Float TotalCart(int u) {
        return cartRepo.TotalCart(u);
    }


}
