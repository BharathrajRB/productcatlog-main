package com.example.productmanagement.controller;

import java.util.ArrayList;
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
    public ResponseEntity<List<OrderHistoryDTO>> getOrderHistory(@RequestHeader("Authorization") String authHeader) {

        try {
            String credentials = new String(Base64.getDecoder().decode(authHeader.split(" ")[1]));
            String splitCredentials[] = credentials.split(":");
            String email = splitCredentials[0];
            String password = splitCredentials[1];
            User user = userService.findByEmailAndPassword(email, password);

            if (user != null) {
                List<Orders> orders = ordersRepository.findByUser(user);
                List<OrderHistoryDTO> orderHistoryDTOList = new ArrayList<>();

                for (Orders order : orders) {
                    OrderHistoryDTO orderHistoryDTO = new OrderHistoryDTO();
                    orderHistoryDTO.setOrderId(order.getId());
                    orderHistoryDTO.setOrderDate(order.getOrderdate());
                    orderHistoryDTO.setPaymentMethod(order.getPayment_id().getName());
                    int totalCount = order.getOrderItems().stream().mapToInt(OrderItem::getQuantity).sum();
                    orderHistoryDTO.setTotalCount(totalCount);
                    orderHistoryDTO.setTotalAmount(order.getTotal_price());
                    orderHistoryDTOList.add(orderHistoryDTO);
                }

                return new ResponseEntity<>(orderHistoryDTOList, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        } catch (Exception e) {
          
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
