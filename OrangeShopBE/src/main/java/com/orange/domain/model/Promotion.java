package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "promotion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promotion extends BaseEntity{
    @Size(max = 205)
    @NotNull
    @Column(name = "name", nullable = false, length = 205)
    private String name;

    @Size(max = 505)
    @Column(name = "description", length = 505)
    private String description;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @NotNull
    @Column(name = "discount", nullable = false)
    private Integer discount;

    @Size(max = 50)
    @NotNull
    @Column(name = "discount_code", nullable = false, length = 50)
    private String discountCode;
    @Column(name = "status")
    private Boolean status;
    @NotNull
    @Column(name = "is_percent", nullable = false)
    private Byte isPercent;

    @ManyToMany(mappedBy = "promotions")
    @JsonIgnore
    private Set<Category> categories;
}