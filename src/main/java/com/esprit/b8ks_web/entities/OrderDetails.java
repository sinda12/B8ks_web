package com.esprit.b8ks_web.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {

    @EmbeddedId
    private OrderDetailsPK orderDetailsPK;

    @ManyToOne
    @JoinColumn(name = "orderId", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "bookId", insertable = false, updatable = false)
    private  Book book;

    private int quantity;

    public OrderDetails() {
    }

    public OrderDetails(OrderDetailsPK orderDetailsPK, int quantity) {
        this.orderDetailsPK = orderDetailsPK;
        this.quantity = quantity;
    }

    public OrderDetails(Order order, Book book, int quantity) {
        this.order = order;
        this.book = book;
        this.quantity = quantity;
    }

    public OrderDetailsPK getOrderDetailsPK() {
        orderDetailsPK = new OrderDetailsPK();
        orderDetailsPK.setOrderId(order.getId());
        orderDetailsPK.setBookId(book.getId());

        return orderDetailsPK;
    }

    public void setOrderDetailsPK(OrderDetailsPK orderDetailsPK) {
        this.orderDetailsPK = orderDetailsPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}