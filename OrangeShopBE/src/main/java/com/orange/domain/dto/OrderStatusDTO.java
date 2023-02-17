package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.orange.domain.model.OrderStatus} entity
 */
@Data
public class OrderStatusDTO extends BaseEntityDTO implements Serializable {
    @Size(max = 50)
    private String status;
}