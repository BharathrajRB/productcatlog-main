package com.example.productmanagement.modal;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private BigDecimal total_price;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentMethod payment_id;
    private String shippingAddress;

    private java.sql.Timestamp orderdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public PaymentMethod getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(PaymentMethod payment_id) {
        this.payment_id = payment_id;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public java.sql.Timestamp getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(java.sql.Timestamp orderdate) {
        this.orderdate = orderdate;
    }

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long orderId;

    // @ManyToOne
    // @JoinColumn(name = "user_id", referencedColumnName = "userId")
    // private User user;

    // private double totalPrice;
    // private String paymentMethod;
    // private String shippingAddress;

    // @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    // private List<OrderItem> orderItem = new ArrayList<>();

    // public Long getOrderId() {
    // return orderId;
    // }

    // public void setOrderId(Long orderId) {
    // this.orderId = orderId;
    // }

    // public User getUser() {
    // return user;
    // }

    // public void setUser(User user) {
    // this.user = user;
    // }

    // public double getTotalPrice() {
    // return totalPrice;
    // }

    // public void setTotalPrice(double totalPrice) {
    // this.totalPrice = totalPrice;
    // }

    // public String getPaymentMethod() {
    // return paymentMethod;
    // }

    // public void setPaymentMethod(String paymentMethod) {
    // this.paymentMethod = paymentMethod;
    // }

    // public String getShippingAddress() {
    // return shippingAddress;
    // }

    // public void setShippingAddress(String shippingAddress) {
    // this.shippingAddress = shippingAddress;
    // }

    // public List<OrderItem> getOrderItem() {
    // return orderItem;
    // }

    // public void setOrderItem(List<OrderItem> orderItem) {
    // this.orderItem = orderItem;
    // }

}
