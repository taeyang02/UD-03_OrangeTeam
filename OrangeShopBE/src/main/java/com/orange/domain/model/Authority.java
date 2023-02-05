package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import lombok.*;

import java.util.Set;

@Entity
@Table(name = "`authority`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    @Column(name = "status")
    private Boolean status;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<User> accounts;
}