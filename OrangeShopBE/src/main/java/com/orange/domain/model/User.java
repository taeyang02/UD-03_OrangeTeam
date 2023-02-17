package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`user`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity{

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 105)
    @NotNull
    @Column(name = "password_hash", nullable = false, length = 105)
    private String passwordHash;

    @Size(max = 105)
    @Column(name = "email", length = 105)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Size(max = 45)
    @Column(name = "first_name", length = 45)
    private String firstName;

    @Size(max = 45)
    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "activate")
    private Boolean activate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<UserPaymentMethod> userPaymentMethods;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<UserReview> userReviews;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<UserAddress> userAddresses;

    @ManyToMany
    @JoinTable(name = "account_authority", joinColumns = {@JoinColumn(name = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Authority> roles = new HashSet<>();

    public User(Long userID) {
        this.setId(userID);
    }
}