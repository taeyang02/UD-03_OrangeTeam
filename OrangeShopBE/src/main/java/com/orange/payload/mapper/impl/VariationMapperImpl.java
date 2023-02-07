package com.orange.payload.mapper.impl;

import com.orange.domain.model.Variation;
import com.orange.payload.mapper.ICategoryMapper;
import com.orange.payload.mapper.IVariationMapper;
import com.orange.payload.response.VariationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VariationMapperImpl implements IVariationMapper {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ICategoryMapper categoryMapper;

    @Override
    public Variation toEntity(VariationDTO dto) {
        Variation entity = modelMapper.map(dto, Variation.class);
        entity.setCategory(categoryMapper.toEntity(dto.getCategory()));
        return entity;
    }

    @Override
    public VariationDTO toDto(Variation entity) {
        VariationDTO dto = modelMapper.map(entity, VariationDTO.class);
        dto.setCategory(categoryMapper.toDto(entity.getCategory()));
        return dto;
    }
}
