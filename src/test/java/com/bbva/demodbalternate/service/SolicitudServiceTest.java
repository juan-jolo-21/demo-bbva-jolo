package com.bbva.demodbalternate.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

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
}
