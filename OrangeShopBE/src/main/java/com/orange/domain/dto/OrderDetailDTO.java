package com.orange.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link com.orange.domain.model.OrderDetail} entity
 */
@Data
public class OrderDetailDTO extends BaseEntityDTO implements Serializable {
    @NotNull
    private Long productDetailId;
    private Long orderId;
    @NotNull
    private Integer quantity;
    private Double price;
}