package com.bbva.demodbalternate.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Data
@Entity
@Table(name= "solicitud_tarjeta")
public class Solicitud {
    @Id
    @Column(name="cod_solicitud")
    private String id;
    private String tit_nombres;
    private String tit_app ;
    private String tit_apm ;
    private long tit_dni ;
    private String producto ;
    private long linea_aprobada ;
    private String status_crediticio ;
    private String status_solicitud;
}
