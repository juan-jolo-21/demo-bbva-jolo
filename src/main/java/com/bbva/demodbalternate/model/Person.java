package com.bbva.demodbalternate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name= "person")
public class Person {
    @Id
    @Column(name =  "dni")
    private long dni;
    private String name_person;
    private String last_name_person;
}
