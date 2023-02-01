package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private Village village;

    @Size(max = 205)
    @Column(name = "address_line1", length = 205)
    private String addressLine1;

    @Size(max = 205)
    @Column(name = "address_line2", length = 205)
    private String addressLine2;

    @Size(max = 45)
    @Column(name = "postal_code", length = 45)
    private String postalCode;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private Set<Order> orders;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private Set<UserAddress> userAddresses;
}