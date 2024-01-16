package com.example.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanagement.modal.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    
}
