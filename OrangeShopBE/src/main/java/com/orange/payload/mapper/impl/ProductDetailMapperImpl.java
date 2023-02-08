package com.orange.payload.mapper.impl;

import com.orange.domain.model.ProductDetail;
import com.orange.payload.mapper.IProductDetailMapper;
import com.orange.payload.mapper.IProductMapper;
import com.orange.payload.mapper.IVariationOptionMapper;
import com.orange.payload.response.ProductDetailDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailMapperImpl implements IProductDetailMapper {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IProductMapper productMapper;
    @Autowired
    private IVariationOptionMapper variationOptionMapper;

    @Override
    public ProductDetail toEntity(ProductDetailDTO dto) {
        ProductDetail entity = modelMapper.map(dto, ProductDetail.class);
        entity.setProduct(productMapper.toEntity(dto.getProduct()));
        entity.setVariationOptions(variationOptionMapper.toEntitySet(dto.getVariationOptions()));
        return entity;
    }

    @Override
    public ProductDetailDTO toDto(ProductDetail entity) {
        ProductDetailDTO dto = modelMapper.map(entity, ProductDetailDTO.class);
        dto.setProduct(productMapper.toDto(entity.getProduct()));
        dto.setVariationOptions(variationOptionMapper.toDtoSet(entity.getVariationOptions()));
        return dto;
    }
}
