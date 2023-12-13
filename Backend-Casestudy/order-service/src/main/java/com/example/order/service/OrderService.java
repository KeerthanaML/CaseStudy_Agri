package com.example.order.service;

import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private static final String CROP_SERVICE_URL = "http://localhost:8083/api/crops";

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Order createOrder(Order order) {
        
        return orderRepository.save(order);
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(String orderId, Order updatedOrder) {
        if (orderRepository.existsById(orderId)) {
            updatedOrder.setOrderId(orderId);
            return orderRepository.save(updatedOrder);
        }
        return null; // or throw an exception or return Optional<Order>
    }

    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }
}
