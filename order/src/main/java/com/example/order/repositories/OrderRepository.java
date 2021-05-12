package com.example.order.repositories;

import com.example.order.domain.Order;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    Optional<Order> findByUserId(Integer userId);

    Optional<Order> findByPriceLessThan(int price);

}
