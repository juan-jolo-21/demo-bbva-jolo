package com.bbva.demodbalternate.dtos;


import javax.validation.Valid;
import javax.validation.constraints.*;

import lombok.Data;

@Data
public class ApplicationDTO {
    @Valid
    @NotNull(message = "Person is not declared but is required")
    private PersonDTO person;
    @NotNull(message = "product_name is required")
    private String product_name;
    @NotNull(message = "approved_credit_limit is required")
    private long approved_credit_limit ;
    @NotNull(message = "credit_state is required")
    private String credit_state ;
    @NotNull(message = "application_state is required")
    private String application_state;
}
