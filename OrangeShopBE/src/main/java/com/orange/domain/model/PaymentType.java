package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "`payment_type`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentType extends BaseEntity{
    @Size(max = 145)
    @NotNull
    @Column(name = "value", nullable = false, length = 145)
    private String value;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "paymentType")
    @JsonIgnore
    private Set<UserPaymentMethod> userPaymentMethods;
}