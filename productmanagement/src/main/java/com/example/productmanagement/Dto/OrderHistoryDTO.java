package com.example.productmanagement.Dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderHistoryDTO {
    private Long orderId;
    private Timestamp orderDate;
    private String payment_id;
    private BigDecimal price;
 

    public OrderHistoryDTO(Long orderId, Timestamp orderDate, BigDecimal price, String payment_id) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.price = price;
        this.payment_id = payment_id;
    }

   

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    // public BigDecimal getPrice() {
    // return price;
    // }

    // public void setPrice(BigDecimal price) {
    // this.price = price;
    // }

}
