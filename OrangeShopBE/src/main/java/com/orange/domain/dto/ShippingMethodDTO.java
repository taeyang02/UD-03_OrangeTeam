package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.orange.domain.model.ShippingMethod} entity
 */
@Data
public class ShippingMethodDTO extends BaseEntityDTO implements Serializable {
    @Size(max = 105)
    @NotNull
    private String name;
    @NotNull
    private Double price;
    private Boolean status;
}