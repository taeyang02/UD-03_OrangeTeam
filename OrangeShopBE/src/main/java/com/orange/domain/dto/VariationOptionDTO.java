package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.orange.domain.model.VariationOption} entity
 */
@Data
public class VariationOptionDTO extends BaseEntityDTO implements Serializable {
    @NotNull
    private VariationDTO variation;
    @Size(max = 505)
    private String value;
}