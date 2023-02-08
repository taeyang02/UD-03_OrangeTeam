package com.orange.payload.mapper.impl;

import com.orange.domain.model.UserPaymentMethod;
import com.orange.payload.mapper.IUserMapper;
import com.orange.payload.mapper.IUserPaymentMethodMapper;
import com.orange.payload.response.UserPaymentMethodDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPaymentMethodMapperImpl implements IUserPaymentMethodMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserMapper userMapper;

    @Override
    public UserPaymentMethod toEntity(UserPaymentMethodDTO dto) {
        UserPaymentMethod entity = modelMapper.map(dto, UserPaymentMethod.class);
        entity.setUser(userMapper.toEntity(dto.getUser()));
        return entity;
    }

    @Override
    public UserPaymentMethodDTO toDto(UserPaymentMethod entity) {
        UserPaymentMethodDTO dto = modelMapper.map(entity, UserPaymentMethodDTO.class);
        dto.setUser(userMapper.toDto(entity.getUser()));
        return dto;
    }
}
