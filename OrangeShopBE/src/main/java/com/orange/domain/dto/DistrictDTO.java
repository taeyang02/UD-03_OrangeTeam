package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.orange.domain.model.District} entity
 */
@Data
public class DistrictDTO extends BaseEntityDTO implements Serializable {
    @NotNull
    private Long cityId;
    @Size(max = 45)
    @NotNull
    private String name;
    private Boolean status;
}