package com.bbva.demodbalternate.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bbva.demodbalternate.model.Solicitud;
import com.bbva.demodbalternate.repository.SolicitudRepository;
import com.bbva.demodbalternate.service.SolicitudService;
import com.bbva.demodbalternate.testData.SolicitudDataTest;

@ExtendWith(MockitoExtension.class)
public class SolicitudServiceTest {
    @Mock
    private SolicitudRepository solicitudRepository;

    @InjectMocks
    private SolicitudService solicitudService;



    @Test
    void testReturnAllSolicitudes() {
        SolicitudDataTest solicitudDataTest = new SolicitudDataTest();
        //Datos de prueba

        List<Solicitud> mockSolicitudes = solicitudDataTest.mockSolicitudes;

        Mockito.when(solicitudRepository.findAll()).thenReturn(mockSolicitudes);

        List<Solicitud> result = solicitudService.findAll();
        assertNotNull(result);
        assertEquals(5, result.size());

    }

    @Test
    void testNoReturnSolicitudes() {

        List<Solicitud> noMockSolicitudes = Collections.emptyList();
        Mockito.when(solicitudRepository.findAll()).thenReturn(noMockSolicitudes);
        List<Solicitud> result = solicitudService.findAll();
        assertNotNull(result);
        assertEquals(0, result.size());

    }

    @Test
    void testReturnSomeSolicitud() {
        SolicitudDataTest solicitudDataTest = new SolicitudDataTest();
        Optional<Solicitud> someSolicitud = Optional.of(solicitudDataTest.s1);
        Mockito.when(solicitudRepository.findById("STC001")).thenReturn(someSolicitud);
        Optional<Solicitud> result = solicitudRepository.findById("STC001");
        assertTrue(result.isPresent());
        assertEquals("STC001", result.get().getId());
        assertEquals(solicitudDataTest.s1.getTit_nombres(), result.get().getTit_nombres());
    }
}
