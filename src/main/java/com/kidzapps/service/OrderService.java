package com.kidzapps.service;

import com.kidzapps.dto.OrderRequest;
import com.kidzapps.entity.Order;
import com.kidzapps.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setEmail(request.getEmail());
        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());
        order.setNotes(request.getNotes());

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
