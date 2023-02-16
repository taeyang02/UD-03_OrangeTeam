package com.orange.domain.mapper.impl;

import com.orange.domain.model.Address;
import com.orange.domain.mapper.IAddressMapper;
import com.orange.domain.dto.AddressDTO;
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
