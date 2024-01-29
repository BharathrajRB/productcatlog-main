package com.example.productmanagement.Dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderHistoryDTO {
    private Timestamp orderDate;
    private String productName;
    private int quantity;
    private BigDecimal price;


    public OrderHistoryDTO(Timestamp orderDate, String productName, int quantity, BigDecimal price) {
        this.orderDate = orderDate;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    
}
