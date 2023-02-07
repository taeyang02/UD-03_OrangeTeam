package com.orange.services;

import com.orange.domain.model.Order;
import com.orange.repositories.IOrderRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll(Pageable pageable){
        return this.orderRepository.findAll(pageable).get().toList();
    }
}
