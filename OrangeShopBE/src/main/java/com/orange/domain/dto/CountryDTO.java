package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.orange.domain.model.Country} entity
 */
@Data
public class CountryDTO extends BaseEntityDTO implements Serializable {
    @Size(max = 45)
    @NotNull
    private String name;
    private Boolean status;
}