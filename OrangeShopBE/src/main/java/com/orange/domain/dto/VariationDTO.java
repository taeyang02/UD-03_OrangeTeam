package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.orange.domain.model.Variation} entity
 */
@Data
public class VariationDTO extends BaseEntityDTO implements Serializable {
    @NotNull
    private Long categoryId;
    @Size(max = 105)
    @NotNull
    private String name;
    private Boolean status;
}