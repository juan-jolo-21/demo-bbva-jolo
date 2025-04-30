package com.bbva.demodbalternate.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class SolicitudDTO {
    public String tit_nombres;
    public String tit_app ;
    public String tit_apm ;
    public long tit_dni ;
    public String producto ;
    public long linea_aprobada ;
    public String status_crediticio ;
    public String status_solicitud;
}
