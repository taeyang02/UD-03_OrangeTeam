package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.orange.domain.model.Village} entity
 */
@Data
public class VillageDTO extends BaseEntityDTO implements Serializable {

    @Size(max = 45)
    @NotNull
    private final String name;
    @NotNull
    private DistrictDTO district;
}