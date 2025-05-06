package com.bbva.demodbalternate.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class PersonDTO{
    @NotNull(message = "DNI is not null")
    @Pattern(regexp = "\\d{8}", message = "dni must have 8 digits")
    private String dni;

    @NotNull(message = "name_person is required")
    private String name_person;

    @NotNull(message = "last_name_person is required")
    private String last_name_person;
}
