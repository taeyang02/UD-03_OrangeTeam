package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "variation_option")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VariationOption extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Variation variation;

    @Size(max = 505)
    @Column(name = "value", length = 505)
    private String value;

    @ManyToMany(mappedBy = "variationOptions")
    @JsonIgnore
    private Set<ProductDetail> productDetails;
}