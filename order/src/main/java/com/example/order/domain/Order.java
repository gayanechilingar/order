package com.example.order.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collation = "orders")
public class Order {
    
    @Id
    private String id;
    private int userId;
    private String productName;

    public Order() {
    }   
            
    public Order(String id, int userId, String productName){    
        this.id = id;
        this.userId = userId;
        this.productName = productName;
    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    
}
