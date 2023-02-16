package com.orange.domain.mapper.impl;

import com.orange.domain.mapper.IUserMapper;
import com.orange.domain.model.UserPaymentMethod;
import com.orange.domain.mapper.IUserPaymentMethodMapper;
import com.orange.domain.dto.UserPaymentMethodDTO;
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
