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

import com.bbva.demodbalternate.model.Application;
import com.bbva.demodbalternate.service.ApplicationService;


import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ApplicationRest.class)
public class SolicitudRestTest {

    // SolicitudDataTest solicitudDataTest = new SolicitudDataTest();

    // @Autowired
    // private MockMvc mockMvc;

    // // Mockea el service que el controlador usa
    // @MockBean
    // private ApplicationService solicitudService;

    // @Test
    // void testGetAllSolicitudes() throws Exception {
    //     List<Application> mockSolicitudes = solicitudDataTest.mockSolicitudes;
    //     // Simula el comportamiento del service
    //     Mockito.when(solicitudService.findAll()).thenReturn(mockSolicitudes);

    //     // Ejecuta petición GET y valida respuesta
    //     mockMvc.perform(get("/solicitud")
    //             .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(status().isOk());
    // }

    // @Test
    // void testNoGetSolicitudes() throws Exception {
    //     List<Application> noSolicitudes = Collections.emptyList();
    //     Mockito.when(solicitudService.findAll()).thenReturn(noSolicitudes);
    //     mockMvc.perform(get("/solicitud")
    //             .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(status().isNoContent());
    // }

    // @Test
    // void testGetSomeSolicitud() throws Exception {
    //     Optional<Application> someSolicitud = Optional.of(solicitudDataTest.s1);
    //     Mockito.when(solicitudService.findById("STC001")).thenReturn(someSolicitud);
    //     mockMvc.perform(get("/solicitud/STC001")
    //         .contentType(MediaType.APPLICATION_JSON))
    //         .andExpect(status().isOk());
    // }

    // @Test
    // void testGetNoExistSolicitud() throws Exception {
    //     Optional<Application> notExist = Optional.empty();
    //     Mockito.when(solicitudService.findById("STC041")).thenReturn(notExist);
    //     mockMvc.perform(get("/solicitud/STC040")
    //         .contentType(MediaType.APPLICATION_JSON))
    //         .andExpect(status().isNotFound());
    // }

}
