package com.bbva.demodbalternate.dtos;

import com.bbva.demodbalternate.model.Person;

import lombok.Data;

@Data
public class ApplicationDTO {
    private Person person;
    private String product_name;
    private long approved_credit_limit ;
    private String credit_state ;
    private String application_state;
}
