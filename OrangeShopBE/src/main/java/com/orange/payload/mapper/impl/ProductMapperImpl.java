package com.orange.payload.mapper.impl;

import com.orange.domain.model.Product;
import com.orange.payload.mapper.ICategoryMapper;
import com.orange.payload.mapper.IProductMapper;
import com.orange.payload.response.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements IProductMapper {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ICategoryMapper categoryMapper;
    @Override
    public Product toEntity(ProductDTO dto) {
        Product entity = modelMapper.map(dto, Product.class);
        entity.setCategory(categoryMapper.toEntity(dto.getCategory()));
        return entity;
    }

    @Override
    public ProductDTO toDto(Product entity) {
        ProductDTO dto = modelMapper.map(entity, ProductDTO.class);
        dto.setCategory(categoryMapper.toDto(entity.getCategory()));
        return dto;
    }
}
