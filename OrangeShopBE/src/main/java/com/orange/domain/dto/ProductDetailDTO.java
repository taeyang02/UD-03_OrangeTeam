package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.orange.domain.model.ProductDetail} entity
 */
@Data
public class ProductDetailDTO extends BaseEntityDTO implements Serializable {

    private Long productId;
    @NotNull
    private Integer quantity;
    @Size(max = 1000)
    private String images;
    @NotNull
    private Double priceDefault;
    private Double priceSale;
    private Set<VariationOptionDTO> variationOptions;
}