package com.orange.services.impl;

import com.orange.domain.model.Order;
import com.orange.exception.EntityNotFoundException;
import com.orange.domain.mapper.IOrderMapper;
import com.orange.domain.dto.OrderDTO;
import com.orange.repositories.IOrderDetailRepository;
import com.orange.repositories.IOrderRepository;
import com.orange.services.IOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private IOrderRepository orderRepository;
    private IOrderDetailRepository orderDetailRepository;
    private IOrderMapper  orderMapper;

    public OrderServiceImpl(IOrderRepository orderRepository, IOrderDetailRepository orderDetailRepository, IOrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDTO create(OrderDTO dto) {
        return null;
    }

    @Override
    public OrderDTO update(OrderDTO dto) {
        return null;
    }

    @Override
    public OrderDTO delete(OrderDTO dto) {
        return null;
    }

    @Override
    public Page<OrderDTO> fillAll(Pageable pageable){
        Page<Order> result = this.orderRepository.findAll(pageable);
        int totalPages = result.getTotalPages();
        List<Order> orderList = result.toList();
        List<OrderDTO> orderDTOList = orderMapper.toDtoList(orderList);
        Page<OrderDTO> orderDTOPage = new PageImpl<>(orderDTOList, pageable, totalPages);
        return orderDTOPage;
    }

    @Override
    public OrderDTO fillById(Long id) {
        Order order = this.orderRepository.findById(id).orElse(null);
        if (order == null) {
            throw new EntityNotFoundException("Order not found!");
        }
        return orderMapper.toDto(order);
    }
}
