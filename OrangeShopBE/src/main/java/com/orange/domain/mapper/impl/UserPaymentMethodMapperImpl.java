package com.orange.domain.mapper.impl;

import com.orange.domain.dto.UserPaymentMethodDTO;
import com.orange.domain.mapper.IUserPaymentMethodMapper;
import com.orange.domain.model.User;
import com.orange.domain.model.UserPaymentMethod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPaymentMethodMapperImpl implements IUserPaymentMethodMapper {

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserPaymentMethod toEntity(UserPaymentMethodDTO dto) {
        UserPaymentMethod entity = modelMapper.map(dto, UserPaymentMethod.class);
        entity.setUser(new User(dto.getUserID()));
        return entity;
    }

    @Override
    public UserPaymentMethodDTO toDto(UserPaymentMethod entity) {
        UserPaymentMethodDTO dto = modelMapper.map(entity, UserPaymentMethodDTO.class);
        dto.setUserID(entity.getUser().getId());
        return dto;
    }
}
