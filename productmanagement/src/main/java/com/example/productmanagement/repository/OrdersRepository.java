package com.example.productmanagement.repository;

import com.example.productmanagement.modal.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
