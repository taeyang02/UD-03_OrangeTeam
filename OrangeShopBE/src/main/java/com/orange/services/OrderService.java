package com.orange.services;

import com.orange.domain.model.Order;
import com.orange.exception.EntityNotFoundException;
import com.orange.payload.mapper.IOrderMapper;
import com.orange.payload.response.OrderDTO;
import com.orange.repositories.IOrderDetailRepository;
import com.orange.repositories.IOrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private IOrderRepository orderRepository;
    private IOrderDetailRepository orderDetailRepository;
    private IOrderMapper  orderMapper;

    public OrderService(IOrderRepository orderRepository, IOrderDetailRepository orderDetailRepository, IOrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.orderMapper = orderMapper;
    }

    public Page<OrderDTO> getAll(Pageable pageable){
        Page<Order> result = this.orderRepository.findAll(pageable);
        int totalPages = result.getTotalPages();
        List<Order> orderList = result.toList();
        List<OrderDTO> orderDTOList = orderMapper.toDtoList(orderList);
        Page<OrderDTO> orderDTOPage = new PageImpl<>(orderDTOList, pageable, totalPages);
        return orderDTOPage;
    }

    public OrderDTO fillOne(Long id) {
        Order order = this.orderRepository.findById(id).orElse(null);
        if (order == null) {
            throw new EntityNotFoundException("Order not found!");
        }
        return orderMapper.toDto(order);
    }
}
