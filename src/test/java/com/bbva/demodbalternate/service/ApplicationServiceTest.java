package com.bbva.demodbalternate.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bbva.demodbalternate.model.Application;
import com.bbva.demodbalternate.repository.ApplicationRepository;
import com.bbva.demodbalternate.testData.ApplicationDataTest;


@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @InjectMocks
    private ApplicationService applicationService;



    @Test
    void testReturnAllApplications() {
        ApplicationDataTest applicationDataTest = new ApplicationDataTest();
        //Datos de prueba

        List<Application> mockApplication = applicationDataTest.mockListApplications;

        Mockito.when(applicationRepository.findAll()).thenReturn(mockApplication);

        List<Application> result = applicationService.findAll();
        assertNotNull(result);
        assertEquals(5, result.size());

    }

    @Test
    void testNoReturnApplications() {

        List<Application> mockApplication = Collections.emptyList();
        Mockito.when(applicationRepository.findAll()).thenReturn(mockApplication);
        List<Application> result = applicationService.findAll();
        assertNotNull(result);
        assertEquals(0, result.size());

    }

    @Test
    void testReturnSomeApplications() {
        ApplicationDataTest applicationDataTest = new ApplicationDataTest();
        Optional<Application> someApplication = Optional.of(applicationDataTest.a1);
        Mockito.when(applicationRepository.findById("ACC001")).thenReturn(someApplication);
        Optional<Application> result = applicationService.findById("ACC001");
        assertTrue(result.isPresent());
        assertEquals("ACC001", result.get().getId());
        assertEquals(applicationDataTest.a1.getPerson().getName_person(), result.get().getPerson().getName_person());
    }

    @Test
    void testNotReturnApplications() {
        Optional<Application> notExist = Optional.empty();
        Mockito.when(applicationRepository.findById("ACC041")).thenReturn(notExist);
        Optional<Application> result = applicationService.findById("ACC041");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSaveApplication() {
        ApplicationDataTest applicationDataTest = new ApplicationDataTest();
        Application someApplication = applicationDataTest.a1;
        Mockito.when(applicationRepository.save(someApplication)).thenReturn(someApplication);
        Application result = applicationService.save(someApplication);

        assertTrue(result != null);
        assertEquals(someApplication, result);

        Mockito.verify(applicationRepository, Mockito.times(1)).save(someApplication);
    }
}
