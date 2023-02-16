package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.orange.domain.model.PaymentType} entity
 */
@Data
public class PaymentTypeDTO extends BaseEntityDTO implements Serializable {
    @Size(max = 145)
    @NotNull
    private String value;
    private Boolean status;
}