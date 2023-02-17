package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "`order`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order extends BaseEntity{
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private UserPaymentMethod userPaymentMethod;

    @Size(max = 105)
    @NotNull
    @Column(name = "consignee_name", nullable = false, length = 105)
    private String consigneeName;

    @NotNull
    @Column(name = "consignee_phone", nullable = false)
    private String consigneePhone;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ShippingMethod shippingMethod;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private OrderStatus orderStatus;

    @Column(name = "order_total")
    private Double orderTotal;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Address address;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Set<OrderDetail> orderDetails;

    public Order(Long orderId) {
        this.setId(orderId);
    }
}