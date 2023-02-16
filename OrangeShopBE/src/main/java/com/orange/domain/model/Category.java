package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parent_category")
    private Category parentCategory;

    @Size(max = 145)
    @Column(name = "name", length = 145)
    private String name;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Variation> variations;

    @ManyToMany
    @JoinTable(name = "category_promotion", joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "promotion_id")})
    private Set<Promotion> promotions = new HashSet<>();

    public Category(Long categoryId) {
        this.setId(categoryId);
    }
}