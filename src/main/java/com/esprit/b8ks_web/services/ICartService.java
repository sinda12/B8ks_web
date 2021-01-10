package com.esprit.b8ks_web.services;

import com.esprit.b8ks_web.entities.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICartService {

    public Cart addCart(Cart c);
    public List<Cart> findALL();
    public String deleteCarts();
    public String deleteCart(int id);
    public List<Cart> userCart(int user_id);
    public void quantityP(int u,int b);
    public void quantityM(int u,int b);
    public Float TotalCart(int u);


}
