package com.esprit.b8ks_web.controllers;

import com.esprit.b8ks_web.entities.Cart;
import com.esprit.b8ks_web.entities.Order;
import com.esprit.b8ks_web.entities.OrderDetails;
import com.esprit.b8ks_web.entities.OrderDetailsPK;
import com.esprit.b8ks_web.entities.util.CartDto;
import com.esprit.b8ks_web.entities.util.CartItemDto;
import com.esprit.b8ks_web.services.CartService;
import com.esprit.b8ks_web.services.IOrderService;
import com.esprit.b8ks_web.services.OrderDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("api/catrs")
public class CartController {

    int u=1;


    @Autowired
    CartService cartService;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OrderDetailsService orderDetailsService;
    @Autowired
    private IOrderService orderService;


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

    @GetMapping("/totalCart")
    public Float TotalCart() {
        return cartService.TotalCart(u);
    }

    @GetMapping("/listCartBook/{us}")
    public List<CartItemDto> userCartBook(@PathVariable int us){

        return cartService.userCart(us).stream().map(e -> {
            CartItemDto cid = new CartItemDto();
            cid.setPrice(e.getBook().getPrice());
            cid.setQuantity(e.getQuantity());
            cid.setTitle(e.getBook().getTitle());
            return cid;
        }).collect(Collectors.toList());
    }

    @GetMapping("/total/cart/{us}")
    public CartDto getCardWithTotal(@PathVariable int us){
       CartDto cartDto = new CartDto();
       cartDto.setCartItemDtos(cartService.userCart(us).stream().map(e -> {
            CartItemDto cid = new CartItemDto();
            cid.setPrice(e.getBook().getPrice());
            cid.setQuantity(e.getQuantity());
            cid.setTitle(e.getBook().getTitle());
            return cid;
        }).collect(Collectors.toList()));
        cartDto.setTotal(cartDto.getCartItemDtos().stream().mapToDouble(cid -> cid.getPrice() * cid.getQuantity()).sum());
        return cartDto;
    }

    @GetMapping("/to-order/{uid}")
    public ResponseEntity<?> proceedToOrder(@PathVariable int uid){
        Order order = new Order();
        List<Cart> carts = cartService.userCart(uid);
        order.setUser(carts.get(0).getUser());
        order.setDate(LocalDate.now());
        order.setTotalPrice(carts.stream().mapToDouble(cid -> cid.getBook().getPrice() * cid.getQuantity()).sum());
        order = orderService.save(order);
        Order finalOrder = order;
        finalOrder.setOrderDetails(new ArrayList<>());

        carts.forEach(c -> {
            OrderDetails orderDetails = new OrderDetails(finalOrder, c.getBook(), c.getQuantity() );
            finalOrder.getOrderDetails().add(orderDetailsService.save(orderDetails));
        });
        return ResponseEntity.ok(orderService.findById(finalOrder.getId()));
    }


}
