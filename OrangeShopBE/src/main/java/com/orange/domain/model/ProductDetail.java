package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetail extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Product product;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Size(max = 1000)
    @Column(name = "images", length = 1000)
    private String images;

    @NotNull
    @Column(name = "price_default", nullable = false)
    private Double priceDefault;

    @Column(name = "price_sale")
    private Double priceSale;

    @OneToMany(mappedBy = "productDetail")
    @JsonIgnore
    private Set<OrderDetail> orderDetails;

    @ManyToMany
    @JoinTable(name = "product_detail_variation_option", joinColumns = {@JoinColumn(name = "product_detail_id")},
            inverseJoinColumns = {@JoinColumn(name = "variation_option_id")})
    private Set<VariationOption> variationOptions = new HashSet<>();

    public ProductDetail(Long productDetailId) {
        this.setId(productDetailId);
    }
}