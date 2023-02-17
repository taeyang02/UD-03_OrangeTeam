package com.orange.domain.mapper.impl;

import com.orange.domain.dto.OrderDetailViewDTO;
import com.orange.domain.mapper.IOrderDetailViewMapper;
import com.orange.domain.mapper.IProductDetailMapper;
import com.orange.domain.model.OrderDetail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailViewMapperImpl implements IOrderDetailViewMapper {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IProductDetailMapper productDetailMapper;

    @Override
    public OrderDetail toEntity(OrderDetailViewDTO dto) {
        OrderDetail entity = modelMapper.map(dto, OrderDetail.class);
        entity.setProductDetail(productDetailMapper.toEntity(dto.getProductDetail()));
        return entity;
    }

    @Override
    public OrderDetailViewDTO toDto(OrderDetail entity) {
        OrderDetailViewDTO dto = modelMapper.map(entity, OrderDetailViewDTO.class);
        dto.setProductDetail(productDetailMapper.toDto(entity.getProductDetail()));
        dto.setProductName(entity.getProductDetail().getProduct().getName());
        return dto;
    }
}
