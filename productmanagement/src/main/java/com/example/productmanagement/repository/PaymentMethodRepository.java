package com.example.productmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanagement.modal.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {
    // public PaymentMethod getById(int paymentMethodId);
  PaymentMethod findById(int paymentMethodId);

}
