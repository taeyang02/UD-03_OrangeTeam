package com.orange.services.impl;

import com.orange.domain.dto.OrderViewDTO;
import com.orange.domain.mapper.IOrderViewMapper;
import com.orange.domain.model.Order;
import com.orange.domain.model.OrderDetail;
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
import java.util.Set;

@Service
public class OrderServiceImpl implements IOrderService {

    private IOrderRepository orderRepository;
    private IOrderDetailRepository orderDetailRepository;
    private IOrderMapper  orderMapper;

    private IOrderViewMapper orderViewMapper;

    public OrderServiceImpl(IOrderRepository orderRepository, IOrderDetailRepository orderDetailRepository, IOrderMapper orderMapper, IOrderViewMapper orderViewMapper) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.orderMapper = orderMapper;
        this.orderViewMapper = orderViewMapper;
    }

    @Override
    public OrderDTO create(OrderDTO dto) {
        Order result = this.orderRepository.save(orderMapper.toEntity(dto));
        Set<OrderDetail> orderDetails = result.getOrderDetails();
        orderDetails.forEach(o -> o.setOrder(result));
        orderDetailRepository.saveAll(orderDetails);
        result.setOrderDetails(orderDetails);
        return orderMapper.toDto(result);
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
    public Page<?> fillAll(Pageable pageable){
        Page<Order> result = this.orderRepository.findAll(pageable);
        int totalPages = result.getTotalPages();
        List<Order> orderList = result.toList();
//        List<OrderDTO> orderDTOList = orderMapper.toDtoList(orderList);
//        Page<OrderDTO> orderDTOPage = new PageImpl<>(orderDTOList, pageable, totalPages);
        List<OrderViewDTO> viewDTOList = orderViewMapper.toDtoList(orderList);
        Page<OrderViewDTO> viewDTOPage = new PageImpl<>(viewDTOList, pageable, totalPages);
        return viewDTOPage;
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
