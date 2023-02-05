package com.orange.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "`user_review`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReview extends BaseEntity{
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private OrderDetail orderDetail;

    @NotNull
    @Column(name = "rating_value", nullable = false)
    private Integer ratingValue;

    @Size(max = 45)
    @NotNull
    @Column(name = "comment", nullable = false, length = 45)
    private String comment;
}