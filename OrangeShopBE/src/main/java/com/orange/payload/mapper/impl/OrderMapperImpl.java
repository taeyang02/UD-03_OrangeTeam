package com.orange.payload.mapper.impl;

import com.orange.domain.model.Order;
import com.orange.payload.mapper.IAddressMapper;
import com.orange.payload.mapper.IOrderDetailMapper;
import com.orange.payload.mapper.IOrderMapper;
import com.orange.payload.mapper.IUserPaymentMethodMapper;
import com.orange.payload.response.OrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperImpl implements IOrderMapper {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IUserPaymentMethodMapper userPaymentMethodMapper;
    @Autowired
    private IAddressMapper addressMapper;
    @Autowired
    private IOrderDetailMapper orderDetailMapper;

    @Override
    public Order toEntity(OrderDTO dto) {
        Order entity = modelMapper.map(dto, Order.class);
        entity.setAddress(addressMapper.toEntity(dto.getAddress()));
        entity.setUserPaymentMethod(userPaymentMethodMapper.toEntity(dto.getUserPaymentMethod()));
        entity.setOrderDetails(orderDetailMapper.toEntity(dto.getOrderDetails()));
        return entity;
    }

    @Override
    public OrderDTO toDto(Order entity) {
        OrderDTO dto = modelMapper.map(entity, OrderDTO.class);
        dto.setAddress(addressMapper.toDto(entity.getAddress()));
        dto.setUserPaymentMethod(userPaymentMethodMapper.toDto(entity.getUserPaymentMethod()));
        dto.setOrderDetails(orderDetailMapper.toDto(entity.getOrderDetails()));
        return dto;
    }
}
