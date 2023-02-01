package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "user_payment_method")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPaymentMethod extends BaseEntity{
    @NotNull
    @ManyToOne
    @JsonIgnore
    private User user;

    @NotNull
    @ManyToOne
    @JsonIgnore
    private PaymentType paymentType;

    @Size(max = 105)
    @Column(name = "provider", length = 105)
    private String provider;

    @Column(name = "account_number")
    private Integer accountNumber;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "is_default")
    private Byte isDefault;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "userPaymentMethod")
    @JsonIgnore
    private Set<Order> orders;
}