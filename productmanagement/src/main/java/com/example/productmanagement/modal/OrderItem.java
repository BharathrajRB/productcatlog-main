package com.example.productmanagement.modal;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private BigDecimal price;
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    // @ManyToOne
    // @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    // private Order order;

    // @ManyToOne
    // @JoinColumn(name = "product_id", referencedColumnName = "id")
    // private Product product;

    // private String name;
    // private double price;
    // private Long quantity;

    // public Long getId() {
    // return id;
    // }
    // public void setId(Long id) {
    // this.id = id;
    // }
    // public Order getOrder() {
    // return order;
    // }
    // public void setOrder(Order order) {
    // this.order = order;
    // }
    // public Product getProduct() {
    // return product;
    // }
    // public void setProduct(Product product) {
    // this.product = product;
    // }
    // public String getName() {
    // return name;
    // }
    // public void setName(String name) {
    // this.name = name;
    // }
    // public double getPrice() {
    // return price;
    // }
    // public void setPrice(double price) {
    // this.price = price;
    // }
    // public Long getQuantity() {
    // return quantity;
    // }
    // public void setQuantity(Long quantity) {
    // this.quantity = quantity;
    // }

}
