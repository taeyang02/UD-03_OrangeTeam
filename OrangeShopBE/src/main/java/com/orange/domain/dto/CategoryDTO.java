package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.orange.domain.model.Category} entity
 */
@Data
public class CategoryDTO extends BaseEntityDTO implements Serializable {
    @Size(max = 145)
    private String name;
    private Boolean status;
    private Long parentCategoryId;
}