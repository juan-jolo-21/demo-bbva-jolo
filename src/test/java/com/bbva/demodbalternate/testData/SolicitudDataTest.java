package com.bbva.demodbalternate.testData;

import java.util.Arrays;
import java.util.List;

import com.bbva.demodbalternate.model.Solicitud;

public class SolicitudDataTest {

    //Datos de prueba
        public Solicitud s1 = new Solicitud();
        public Solicitud s2 = new Solicitud();
        public Solicitud s3 = new Solicitud();
        public Solicitud s4 = new Solicitud();
        public Solicitud s5 = new Solicitud();
        public List<Solicitud> mockSolicitudes ;
        public List<Solicitud> noSolicitudesMock ;

        public SolicitudDataTest() {
            s1.setId("STC001");
            s2.setId("STC002");
            s3.setId("STC003");
            s4.setId("STC004");
            s5.setId("STC005");

            s1.setTit_nombres("Andres");
            s2.setTit_nombres("Eduardo");
            s3.setTit_nombres("Javier");
            s4.setTit_nombres("Leandro");
            s5.setTit_nombres("Javier");

            s1.setTit_app("Sanchez");
            s2.setTit_app("Lujan");
            s3.setTit_app("Alva");
            s4.setTit_app("Matamoros");
            s5.setTit_app("Paredes");

            s1.setTit_apm("Castillo");
            s2.setTit_apm("Flores");
            s3.setTit_apm("Perez");
            s4.setTit_apm("Gamarra");
            s5.setTit_apm("Rivera");

            s1.setTit_dni(77411201);
            s2.setTit_dni(77411202);
            s3.setTit_dni(77411203);
            s4.setTit_dni(77411204);
            s5.setTit_dni(77411205);

            s1.setProducto("platinum");
            s2.setProducto("platinum");
            s3.setProducto("platinum");
            s4.setProducto("platinum");
            s5.setProducto("platinum");

            s1.setLinea_aprobada(4000);
            s2.setLinea_aprobada(4000);
            s3.setLinea_aprobada(4000);
            s4.setLinea_aprobada(4000);
            s5.setLinea_aprobada(4000);

            s1.setStatus_crediticio("normal");
            s2.setStatus_crediticio("normal");
            s3.setStatus_crediticio("normal");
            s4.setStatus_crediticio("normal");
            s5.setStatus_crediticio("normal");

            s1.setStatus_solicitud("aprobado");
            s2.setStatus_solicitud("aprobado");
            s3.setStatus_solicitud("aprobado");
            s4.setStatus_solicitud("aprobado");
            s5.setStatus_solicitud("aprobado");

            mockSolicitudes= Arrays.asList(s1,s2,s3,s4,s5);
        }
        
}
