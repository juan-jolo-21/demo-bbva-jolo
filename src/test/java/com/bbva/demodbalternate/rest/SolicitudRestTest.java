package com.bbva.demodbalternate.rest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.bbva.demodbalternate.model.Solicitud;
import com.bbva.demodbalternate.service.SolicitudService;
import com.bbva.demodbalternate.testData.SolicitudDataTest;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SolicitudRest.class)
public class SolicitudRestTest {

    SolicitudDataTest solicitudDataTest = new SolicitudDataTest();

    @Autowired
    private MockMvc mockMvc;

    // Mockea el service que el controlador usa
    @MockBean
    private SolicitudService solicitudService;

    @Test
    void testGetAllSolicitudes() throws Exception {
        List<Solicitud> mockSolicitudes = solicitudDataTest.mockSolicitudes;
        // Simula el comportamiento del service
        Mockito.when(solicitudService.findAll()).thenReturn(mockSolicitudes);

        // Ejecuta petición GET y valida respuesta
        mockMvc.perform(get("/solicitud")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testNoGetSolicitudes() throws Exception {
        List<Solicitud> noSolicitudes = Collections.emptyList();
        Mockito.when(solicitudService.findAll()).thenReturn(noSolicitudes);
        mockMvc.perform(get("/solicitud")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetSomeSolicitud() throws Exception {
        Optional<Solicitud> someSolicitud = Optional.of(solicitudDataTest.s1);
        Mockito.when(solicitudService.findById("STC001")).thenReturn(someSolicitud);
        mockMvc.perform(get("/solicitud/STC001")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

}
