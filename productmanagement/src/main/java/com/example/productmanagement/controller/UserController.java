package com.example.productmanagement.controller;

import com.example.productmanagement.modal.CartItem;
import com.example.productmanagement.modal.Product;
import com.example.productmanagement.modal.User;
import com.example.productmanagement.repository.CartItemRepository;
import com.example.productmanagement.service.UserService;
import com.example.productmanagement.service.ProductService;
import com.example.productmanagement.service.UserAlreadyExistsException;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartItemRepository cartItemRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestHeader("Authorization") String authHeader) {
        try {
            String credentials = new String(Base64.getDecoder().decode(authHeader.split(" ")[1]));
            String[] splitCredentials = credentials.split(":");
            String email = splitCredentials[0];
            String password = splitCredentials[1];

            User user = userService.findByEmailAndPassword(email, password);

            if (user != null) {
                String role = user.getRole_id().getName();
                String encodedCredentials = userService.encodeCredentials(email, password);
                System.out.println("Encoded Credentials: " + encodedCredentials);
                return new ResponseEntity<>("Login successful. Role: " + role, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error during login", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addtocart/{productId}")
    public ResponseEntity<String> addtocart(@PathVariable Long productId, @RequestParam int quantity,
            @RequestHeader("Authorization") String authHeader) {
        try {
            String credentials = new String(Base64.getDecoder().decode(authHeader.split(" ")[1]));
            String[] splitCredentials = credentials.split(":");
            String email = splitCredentials[0];
            String password = splitCredentials[1];
            User user = userService.findByEmailAndPassword(email, password);
            Product product = productService.getProductById(productId);
            if (user != null && product != null) {

                Optional<CartItem> existingCartItem = cartItemRepository.findByUserAndProduct(user, product);

                if (existingCartItem.isPresent()) {
                    CartItem cartItem = existingCartItem.get();
                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
                    cartItemRepository.save(cartItem);

                } else {
                    CartItem cartItem = new CartItem();
                    cartItem.setProduct(product);
                    cartItem.setQuantity(quantity);
                    cartItem.setUser(user);
                    cartItemRepository.save(cartItem);
                }
                return new ResponseEntity<>("Product added to the cart successfully", HttpStatus.OK);

            } else {
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("error in handling", HttpStatus.BAD_REQUEST);
        }
    }

    // @PostMapping("/addtocart/{productId}")
    // public ResponseEntity<String> addtocart(@PathVariable Long productId,
    // @RequestParam int quantity,
    // @RequestHeader("Authorization") String authHeader) {
    // try {

    // String credentials = new String(Base64.getDecoder().decode(authHeader.split("
    // ")[1]));
    // String[] splitCredentials = credentials.split(":");
    // String email = splitCredentials[0];
    // String password = splitCredentials[1];

    // User user = userService.getUserByemail(email);
    // Product product = productService.getProductById(productId);
    // System.out.println("product id");

    // if (product != null) {
    // CartItem cartItem = new CartItem();
    // cartItem.setProduct(product);
    // cartItem.setQuantity(quantity);
    // cartItem.setUser(user);
    // cartItemRepository.save(cartItem);
    // return new ResponseEntity<>("product added to the cart successfully",
    // HttpStatus.OK);

    // } else {
    // return new ResponseEntity<>("product not found", HttpStatus.NOT_FOUND);
    // }

    // } catch (Exception e) {
    // return new ResponseEntity<>("error in adding product to cart",
    // HttpStatus.BAD_REQUEST);

    // }
    // }

    // @GetMapping("/viewcart")
    // public ResponseEntity<?> viewcart(@RequestHeader("Authorization") String
    // authHeader) {
    // try {
    // String credentials = new String(Base64.getDecoder().decode(authHeader.split("
    // ")[1]));
    // String[] splitCredentials = credentials.split(":");
    // String email = splitCredentials[0];
    // String password = splitCredentials[1];
    // User user = userService.getUserByemail(email);
    // List<CartItem> cartItems = user.getCartItems();
    // double totalPrice = cartItems.stream()
    // .mapToDouble(item -> item.getProduct().getPrice() *
    // item.getQuantity())
    // .sum();
    // Map<String, Object> response = new HashMap<>();
    // response.put("cartItems", cartItems);
    // response.put("totalPrice", totalPrice);
    // return new ResponseEntity<>(response, HttpStatus.OK);

    // } catch (Exception e) {
    // return new ResponseEntity<>("error in viewing product",
    // HttpStatus.BAD_REQUEST);
    // }
    // }
}
