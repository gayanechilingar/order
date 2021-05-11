package com.example.order.controlers;

import com.example.order.domain.Order;
import com.example.order.services.OrderService;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gayane
 */
@RestController
@RequestMapping("/api/v2/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        log.info("Create order");

//        if (order.getId()== 0 || order.getUserId()== 0|| order.getProductName() == null ) {
//            log.error("Could not create order");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You must fill id/userid or product name fields");
//        }

        Optional<Order> savedOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.OK).body(savedOrder.get());
    }



}
