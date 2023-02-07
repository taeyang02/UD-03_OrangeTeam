package com.orange.payload.response;

import com.orange.domain.model.Village;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link com.orange.domain.model.Address} entity
 */
@Data
public class AddressDTO implements Serializable {
    @NotNull
    private Village village;
    @Size(max = 205)
    private String addressLine1;
    @Size(max = 205)
    private String addressLine2;
    @Size(max = 45)
    private String postalCode;
    private Boolean status;
}