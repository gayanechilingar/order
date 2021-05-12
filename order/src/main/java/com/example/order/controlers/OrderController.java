package com.example.order.controlers;

import com.example.order.domain.Order;
import com.example.order.services.OrderService;
import java.util.List;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        Optional<Order> savedOrder = orderService.createOrder(order);

        if (savedOrder.isPresent()) {
            log.info("Order saved and all ok !");
            return ResponseEntity.status(HttpStatus.OK).body(savedOrder.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Sorry I cant save ths order, please try again!!!!!");
    }

    @GetMapping(path = "/find/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());

    }
    
    @PostMapping(path = "/find/by/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> fetch(@RequestParam Integer userId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findByUserId(userId));

    }
    
    @PostMapping(path = "/find/by/filterprice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> filter(@RequestParam int price) {
        
        Optional <Order> foundOrders = orderService.findByPrice(price);
        if(foundOrders.isPresent()){
            log.info("here");
            return ResponseEntity.status(HttpStatus.OK).body(orderService.findByPrice(price));
        
        }
         log.info("chexav");
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sorry I can't filter ths order");

    }
    @PostMapping(path = "/delete/by/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public void  delete(@RequestParam String id ) {
//        if(price<=filter){
       orderService.delete(id);
        
//        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Sorry I cant filter ths order, please try again!!!!!");
    }

}
