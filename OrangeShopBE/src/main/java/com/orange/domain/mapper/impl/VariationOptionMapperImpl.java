package com.orange.domain.mapper.impl;

import com.orange.domain.model.VariationOption;
import com.orange.domain.mapper.IVariationMapper;
import com.orange.domain.mapper.IVariationOptionMapper;
import com.orange.domain.dto.VariationOptionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VariationOptionMapperImpl  implements IVariationOptionMapper {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IVariationMapper variationMapper;

    @Override
    public VariationOption toEntity(VariationOptionDTO dto) {
        VariationOption entity = modelMapper.map(dto, VariationOption.class);
        entity.setVariation(variationMapper.toEntity(dto.getVariation()));
        return entity;
    }

    @Override
    public VariationOptionDTO toDto(VariationOption entity) {
        VariationOptionDTO dto = modelMapper.map(entity, VariationOptionDTO.class);
        dto.setVariation(variationMapper.toDto(entity.getVariation()));
        return dto;
    }
}
