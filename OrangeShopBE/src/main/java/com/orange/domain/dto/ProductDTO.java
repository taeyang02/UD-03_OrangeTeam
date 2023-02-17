package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.orange.domain.model.Product} entity
 */
@Data
public class ProductDTO extends BaseEntityDTO implements Serializable {
    @NotNull
    private Long categoryId;
    @Size(max = 215)
    @NotNull
    private String name;
    @Size(max = 1005)
    private String description;
    private Boolean status;
    @Size(max = 505)
    @NotNull
    private String defaultImage;
    private Set<ProductDetailDTO> productDetails;
}