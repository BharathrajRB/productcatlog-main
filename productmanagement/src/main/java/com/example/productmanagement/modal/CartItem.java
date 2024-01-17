package com.example.productmanagement.modal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public BigDecimal calculateTotalPrice() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    // @JoinColumn(name = "product_id")
    // private Product product;
    // private int quantity;
    // @ManyToOne
    // @JoinColumn(name = "user_id")
    // @JsonBackReference
    // private User user;
    // public Long getId() {
    // return id;
    // }
    // public void setId(Long id) {
    // this.id = id;
    // }
    // public Product getProduct() {
    // return product;
    // }
    // public void setProduct(Product product) {
    // this.product = product;
    // }
    // public int getQuantity() {
    // return quantity;
    // }
    // public void setQuantity(int quantity) {
    // this.quantity = quantity;
    // }
    // public User getUser() {
    // return user;
    // }
    // public void setUser(User user) {
    // this.user = user;
    // }

}
