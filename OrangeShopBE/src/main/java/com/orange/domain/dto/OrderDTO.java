package com.orange.domain.dto;

import com.orange.domain.model.OrderStatus;
import com.orange.domain.model.ShippingMethod;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.orange.domain.model.Order} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO extends BaseEntityDTO implements Serializable {

    @Size(max = 105)
    @NotNull
    private String consigneeName;
    @NotNull
    private String consigneePhone;
    private Double orderTotal;
    private UserPaymentMethodDTO userPaymentMethod;
    private ShippingMethod shippingMethod;
    private OrderStatus orderStatus;
    private AddressDTO address;
    private Set<OrderDetailDTO> orderDetails;
}