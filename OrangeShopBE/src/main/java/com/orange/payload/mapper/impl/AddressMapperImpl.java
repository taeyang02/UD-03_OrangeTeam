package com.orange.payload.mapper.impl;

import com.orange.domain.model.Address;
import com.orange.payload.mapper.IAddressMapper;
import com.orange.payload.response.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements IAddressMapper {
    @Override
    public Address toEntity(AddressDTO dto) {
        return null;
    }

    @Override
    public AddressDTO toDto(Address entity) {
        return null;
    }
}
