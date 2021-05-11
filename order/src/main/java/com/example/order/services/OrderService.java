package com.example.order.services;

import com.example.order.domain.Order;
import com.example.order.repositories.OrderRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lilith
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> createOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        return Optional.ofNullable(savedOrder);
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
}
