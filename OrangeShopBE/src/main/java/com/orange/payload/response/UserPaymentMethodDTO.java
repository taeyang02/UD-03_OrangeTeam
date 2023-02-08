package com.orange.payload.response;

import com.orange.domain.model.PaymentType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.orange.domain.model.UserPaymentMethod} entity
 */
@Data
public class UserPaymentMethodDTO extends BaseEntityDTO implements Serializable {
    @NotNull
    private UserDTO user;
    @NotNull
    private PaymentType paymentType;
    @Size(max = 105)
    private String provider;
    private BigInteger accountNumber;
    private LocalDate expiryDate;
    private Boolean isDefault;
    private Boolean status;
}