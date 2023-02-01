package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "variation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Variation extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Category category;

    @Size(max = 105)
    @NotNull
    @Column(name = "name", nullable = false, length = 105)
    private String name;

    @Column(name = "status")
    private Boolean status;
    @OneToMany(mappedBy = "variation")
    @JsonIgnore
    private Set<VariationOption> variationOptions;
}