package com.orange.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "order_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderStatus extends BaseEntity{

    @Size(max = 50)
    @Column(name = "status", length = 50)
    private String status;
}