package com.orange.domain.mapper.impl;

import com.orange.domain.model.Address;
import com.orange.domain.mapper.IAddressMapper;
import com.orange.domain.dto.AddressDTO;
import com.orange.domain.model.Village;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements IAddressMapper {

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Address toEntity(AddressDTO dto) {
        Address entity = modelMapper.map(dto, Address.class);
        entity.setVillage(new Village(dto.getVillageId()));
        return entity;
    }

    @Override
    public AddressDTO toDto(Address entity) {
        AddressDTO dto = modelMapper.map(entity, AddressDTO.class);
        dto.setVillageId(entity.getVillage().getId());
        return dto;
    }
}
