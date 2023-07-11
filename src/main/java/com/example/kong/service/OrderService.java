package com.example.kong.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import com.example.kong.entity.Order;
import com.example.kong.repository.OrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {

        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long id) {

        return orderRepository.findById(id);

    }

    public void deleteOrder(Long id) {

        if(!orderRepository.existsById(id)) {
            throw new ObjectNotFoundException(id, null);
        }
        orderRepository.deleteById(id);
    }

    public Order updateOrder(Long id, Order order) {

        if(!orderRepository.existsById(id)) {
            throw new ObjectNotFoundException(id, null);
        }
        order.setId(id);
        Order updatedOrder = orderRepository.save(order);
        return updatedOrder;
    }
}
