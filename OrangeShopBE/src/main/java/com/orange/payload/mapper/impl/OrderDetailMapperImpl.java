package com.orange.payload.mapper.impl;

import com.orange.domain.model.Order;
import com.orange.domain.model.OrderDetail;
import com.orange.payload.mapper.IOrderDetailMapper;
import com.orange.payload.mapper.IOrderMapper;
import com.orange.payload.mapper.IProductDetailMapper;
import com.orange.payload.response.OrderDetailDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapperImpl implements IOrderDetailMapper {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IProductDetailMapper productDetailMapper;

    @Override
    public OrderDetail toEntity(OrderDetailDTO dto) {
        OrderDetail entity = modelMapper.map(dto, OrderDetail.class);
        entity.setOrder(new Order(dto.getOrderId()));
        entity.setProductDetail(productDetailMapper.toEntity(dto.getProductDetail()));
        return entity;
    }

    @Override
    public OrderDetailDTO toDto(OrderDetail entity) {
        OrderDetailDTO dto = modelMapper.map(entity, OrderDetailDTO.class);
        dto.setOrderId(entity.getOrder().getId());
        dto.setProductDetail(productDetailMapper.toDto(entity.getProductDetail()));
        return dto;
    }
}
