package com.example.productmanagement.repository;

import com.example.productmanagement.modal.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
