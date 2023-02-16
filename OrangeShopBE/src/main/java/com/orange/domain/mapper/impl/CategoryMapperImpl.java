package com.orange.domain.mapper.impl;

import com.orange.domain.model.Category;
import com.orange.domain.mapper.ICategoryMapper;
import com.orange.domain.dto.CategoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements ICategoryMapper {

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Category toEntity(CategoryDTO dto) {
        Category entity = modelMapper.map(dto, Category.class);
        if (dto.getParentCategoryId() != null && dto.getParentCategoryId() > 0) {
            Category parentCategory = new Category();
            parentCategory.setId(dto.getParentCategoryId());
            entity.setParentCategory(parentCategory);
        }

        return entity;
    }

    @Override
    public CategoryDTO toDto(Category entity) {
        CategoryDTO dto = modelMapper.map(entity, CategoryDTO.class);
        if (entity.getParentCategory() != null) {
            dto.setParentCategoryId(entity.getParentCategory().getId());
        }

        return dto;
    }
}
