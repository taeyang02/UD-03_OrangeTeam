package com.orange.domain.dto;

import com.orange.domain.model.OrderStatus;
import com.orange.domain.model.ShippingMethod;
import lombok.Data;

import java.util.Set;

@Data
public class OrderViewDTO {
    private Long id;
    private String createDate;
    private Integer productQuantity;
    private Double orderTotal;
    private OrderStatus status;
    private AddressDTO address;
    private ShippingMethod shippingMethod;
    private Set<OrderDetailViewDTO> orderDetailViews;
}
