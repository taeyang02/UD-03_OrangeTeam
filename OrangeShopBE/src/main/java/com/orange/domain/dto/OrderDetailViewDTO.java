package com.orange.domain.dto;

import lombok.Data;

@Data
public class OrderDetailViewDTO {
    private Long id;
    private String productName;
    private ProductDetailDTO productDetail;
    private Integer quantity;
    private Double price;
}
