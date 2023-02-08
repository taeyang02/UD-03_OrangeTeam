package com.orange.services;

import com.orange.domain.model.Order;
import com.orange.exception.EntityNotFoundException;
import com.orange.payload.mapper.IOrderMapper;
import com.orange.payload.response.OrderDTO;
import com.orange.repositories.IOrderRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private IOrderRepository orderRepository;
    private IOrderMapper  orderMapper;

    public OrderService(IOrderRepository orderRepository, IOrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> getAll(Pageable pageable){
        List<Order> list = this.orderRepository.findAll(pageable).get().toList();

        return orderMapper.toDtoList(list);
    }

    public OrderDTO fillOne(Long id) {
        Order order = this.orderRepository.findById(id).orElse(null);
        if (order == null) {
            throw new EntityNotFoundException("Order not found!");
        }
        return orderMapper.toDto(order);
    }
}
