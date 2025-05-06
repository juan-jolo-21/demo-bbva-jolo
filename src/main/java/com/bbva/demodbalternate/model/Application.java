package com.bbva.demodbalternate.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name= "application")
public class Application {
    @Id
    @Column(name = "id")
    private String id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_dni")
    private Person person;
    private String product_name;
    private long approved_credit_limit ;
    private String credit_state ;
    private String application_state;
}
