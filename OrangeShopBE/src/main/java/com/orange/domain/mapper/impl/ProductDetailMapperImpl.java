package com.orange.domain.mapper.impl;

import com.orange.domain.dto.ProductDetailDTO;
import com.orange.domain.mapper.IProductDetailMapper;
import com.orange.domain.mapper.IVariationOptionMapper;
import com.orange.domain.model.Product;
import com.orange.domain.model.ProductDetail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailMapperImpl implements IProductDetailMapper {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IVariationOptionMapper variationOptionMapper;

    @Override
    public ProductDetail toEntity(ProductDetailDTO dto) {
        ProductDetail entity = modelMapper.map(dto, ProductDetail.class);
        entity.setProduct(new Product(dto.getProductId()));
        entity.setVariationOptions(variationOptionMapper.toEntitySet(dto.getVariationOptions()));
        return entity;
    }

    @Override
    public ProductDetailDTO toDto(ProductDetail entity) {
        ProductDetailDTO dto = modelMapper.map(entity, ProductDetailDTO.class);
        dto.setProductId(entity.getProduct().getId());
        dto.setVariationOptions(variationOptionMapper.toDtoSet(entity.getVariationOptions()));
        return dto;
    }
}
