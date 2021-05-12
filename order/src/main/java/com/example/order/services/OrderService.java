package com.example.order.services;

import com.example.order.domain.Order;
import com.example.order.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Gayane
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Optional<Order> createOrder(Order order) {

        order.setId(null);

//        if (order.getUserId() == null) {
//            log.error("You should provide user id");
//            return Optional.empty();
//        }

        log.info("user id " + order.getUserId());
        Optional<Order> existingOrder = orderRepository.findByUserId(order.getUserId());

        if (existingOrder.isPresent()) {
            log.error("User already has order, we cant save new order");
            return Optional.empty();
        }

//        for (int i = 0; i < 10000; i++) {
//            order.setUserId(i + 5);
//            order.setProductName("Product_" + System.currentTimeMillis());
//            orderRepository.save(order);
//        }

        Order savedOrder = orderRepository.save(order);

        log.info("order is saved and order id is " + savedOrder.getId());

        return Optional.ofNullable(savedOrder);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findByUserId(Integer id) {
        return orderRepository.findByUserId(id);
    }
    public Optional<Order> findByPrice(int price) {
        return orderRepository.findByPriceLessThan(price);
    }
    public void delete(String id) {
        orderRepository.deleteById(id);
    }
//    public Account updateAccount(Account account) {
//        log.info("Creating Patient");
//        if (account.getId() == null) {
//            log.error("provide patient id for update");
//            return new Account();
//        }
//        log.info("Update patient with id " + account.getId());
//        Account updatedAccount = accountRepository.save(account);
//        return updatedAccount;
//    }
//
//    public void removeAccount(Long accountId) {
//        log.info("find patient with id and delete");
//        accountRepository.deleteById(accountId);
//    }
//
//    public List<Account> findAllSavedAccounts() {
//        log.info("find all patients, return Array List or List");
//        return (List<Account>) accountRepository.findAll();
//    }
    //https://github.com/DiUS/java-faker
}
