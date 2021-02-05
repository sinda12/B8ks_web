package com.esprit.b8ks_web.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailsPK implements Serializable {


    private Long orderId;
    private Long bookId;

    public OrderDetailsPK() {
    }

    public OrderDetailsPK(Long orderId, Long bookId) {
        this.orderId = orderId;
        this.bookId = bookId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
