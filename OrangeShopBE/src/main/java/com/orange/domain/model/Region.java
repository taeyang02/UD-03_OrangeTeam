package com.orange.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "region")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Region extends BaseEntity{
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Country country;

    @Size(max = 45)
    @NotNull
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "status")
    private Boolean status;
}