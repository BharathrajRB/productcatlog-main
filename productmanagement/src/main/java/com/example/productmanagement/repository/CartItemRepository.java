package com.example.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanagement.modal.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    
}