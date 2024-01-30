package com.example.productmanagement.controller;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.productmanagement.Dto.OrderHistoryDTO;
import com.example.productmanagement.modal.OrderItem;
import com.example.productmanagement.modal.Orders;
import com.example.productmanagement.modal.User;
import com.example.productmanagement.repository.OrderItemRepository;
import com.example.productmanagement.repository.OrdersRepository;
import com.example.productmanagement.service.UserService;

@RestController
public class OrderController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping("/order-history")
    public ResponseEntity<List<OrderHistoryDTO>> getOrderHistory(@RequestHeader("authorization") String authHeader) {
        try {
            String credentials = new String(Base64.getDecoder().decode(authHeader.split(" ")[1]));
            String splitCredentials[] = credentials.split(":");
            String email = splitCredentials[0];
            String password = splitCredentials[1];
            User user = userService.findByEmailAndPassword(email, password);
            if (user != null) {
                List<Orders> orders = ordersRepository.findByUser(user);
                // List<OrderItem> orderItems = orderItemRepository.findByOrderUser(user);
                List<OrderHistoryDTO> OrderHistoryDTO = orders.stream()
                        .map(item -> new OrderHistoryDTO(item.getId(), item.getOrderdate(), item.getTotal_price(),item.getPayment_id().getName()))
                        .collect(Collectors.toList());
                return new ResponseEntity<>(OrderHistoryDTO, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
