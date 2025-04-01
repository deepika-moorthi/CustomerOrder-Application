package com.ecom.CustomerOrder.controller;


import com.ecom.CustomerOrder.model.Order;
import com.ecom.CustomerOrder.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@Tag(name = "Customer API", description = "Operations related to customers")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return service.addOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }

    @PostMapping("/bulk")
    public List<Order> addOrders(@RequestBody List<Order> orders) {
        System.out.println("Received orders: " + orders);
        return service.addOrders(orders);
    }
}

