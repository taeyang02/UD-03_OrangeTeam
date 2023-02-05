package com.orange.services;

import com.orange.domain.model.Order;
import com.orange.repositories.IOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll(){
        return this.orderRepository.findAll();
    }
}
