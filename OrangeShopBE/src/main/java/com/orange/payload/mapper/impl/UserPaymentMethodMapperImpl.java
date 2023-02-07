package com.orange.payload.mapper.impl;

import com.orange.domain.model.UserPaymentMethod;
import com.orange.payload.mapper.IUserPaymentMethodMapper;
import com.orange.payload.response.UserPaymentMethodDTO;
import org.springframework.stereotype.Component;

@Component
public class UserPaymentMethodMapperImpl implements IUserPaymentMethodMapper {
    @Override
    public UserPaymentMethod toEntity(UserPaymentMethodDTO dto) {
        return null;
    }

    @Override
    public UserPaymentMethodDTO toDto(UserPaymentMethod entity) {
        return null;
    }
}
