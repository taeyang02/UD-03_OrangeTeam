package com.orange.domain.mapper.impl;

import com.orange.domain.dto.ProductDTO;
import com.orange.domain.mapper.ICategoryMapper;
import com.orange.domain.mapper.IProductMapper;
import com.orange.domain.model.Category;
import com.orange.domain.model.Product;
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
        entity.setCategory(new Category(dto.getCategoryId()));
        return entity;
    }

    @Override
    public ProductDTO toDto(Product entity) {
        ProductDTO dto = modelMapper.map(entity, ProductDTO.class);
        dto.setCategoryId(entity.getCategory().getId());
        return dto;
    }
}
