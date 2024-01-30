package com.example.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import com.example.productmanagement.repository.OrdersRepository;
import com.example.productmanagement.service.UserService;

@RestController
public class OrderController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrdersRepository ordersRepository;

}
