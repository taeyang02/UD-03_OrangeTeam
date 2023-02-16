package com.orange.domain.mapper.impl;

import com.orange.domain.model.User;
import com.orange.domain.mapper.IUserMapper;
import com.orange.domain.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements IUserMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User toEntity(UserDTO dto) {
        User entity = modelMapper.map(dto, User.class);
        return entity;
    }

    @Override
    public UserDTO toDto(User entity) {
        UserDTO dto = modelMapper.map(entity, UserDTO.class);
        return dto;
    }
}
