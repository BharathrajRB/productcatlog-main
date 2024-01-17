package com.example.productmanagement.repository;

import java.util.Optional;

import javax.swing.text.html.Option;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanagement.modal.CartItem;
import com.example.productmanagement.modal.Product;
import com.example.productmanagement.modal.User;

import jakarta.transaction.Transactional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
  Optional<CartItem> findByUserAndProduct(User user, Product product);

  // @Transactional
  // void deleteAllByUserId(Long userId);
  List<CartItem> findByUser(User user);
}