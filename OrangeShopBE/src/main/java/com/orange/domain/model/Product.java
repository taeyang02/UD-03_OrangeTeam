package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category category;

    @Size(max = 215)
    @NotNull
    @Column(name = "name", nullable = false, length = 215)
    private String name;

    @Size(max = 1005)
    @Column(name = "description", length = 1005)
    private String description;
    @Column(name = "status")
    private Boolean status;
    @Size(max = 505)
    @NotNull
    @Column(name = "default_image", nullable = false, length = 505)
    private String defaultImage;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<ProductDetail> productDetails;

    public Product(Long productId) {
        this.setId(productId);
    }
}