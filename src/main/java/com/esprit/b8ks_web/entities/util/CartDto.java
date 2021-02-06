package com.esprit.b8ks_web.entities.util;

import java.util.List;

public class CartDto {



    private List<CartItemDto> cartItemDtos;
    private double total;


    public List<CartItemDto> getCartItemDtos() {
        return cartItemDtos;
    }

    public void setCartItemDtos(List<CartItemDto> cartItemDtos) {
        this.cartItemDtos = cartItemDtos;
    }
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}