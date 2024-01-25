package com.example.productmanagement.repository;

import com.example.productmanagement.modal.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.productmanagement.modal.User;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByUser(User user);

    List<Orders> findByUserId(Long id);
}
