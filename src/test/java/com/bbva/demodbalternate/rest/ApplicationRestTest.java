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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.bbva.demodbalternate.testData.ApplicationDataTest;


@WebMvcTest(ApplicationRest.class)
public class ApplicationRestTest {
// SolicitudDataTest solicitudDataTest = new SolicitudDataTest();

    @Autowired
    private MockMvc mockMvc;

    // Mockea el service que el controlador usa
    @MockBean
    private ApplicationService applicationService;

    @Test
    void testGetAllSolicitudes() throws Exception {
        ApplicationDataTest applicationDataTest = new ApplicationDataTest();
        List<Application> mockListApplications = applicationDataTest.mockListApplications ;
        // Simula el comportamiento del service
        Mockito.when(applicationService.findAll()).thenReturn(mockListApplications);

        // Ejecuta petición GET y valida respuesta
        mockMvc.perform(get("/application")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testNoGetApplications() throws Exception {
        List<Application> notFoundApplications = Collections.emptyList();
        Mockito.when(applicationService.findAll()).thenReturn(notFoundApplications);
        mockMvc.perform(get("/application")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetSomeApplication() throws Exception {
        ApplicationDataTest applicationDataTest = new ApplicationDataTest();
        Optional<Application> someApplication = Optional.of(applicationDataTest.a1);
        Mockito.when(applicationService.findById("ACC001")).thenReturn(someApplication);
        mockMvc.perform(get("/application/ACC001")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    void testGetNoExistApplication() throws Exception {
        Optional<Application> notExist = Optional.empty();
        Mockito.when(applicationService.findById("ACC041")).thenReturn(notExist);
        mockMvc.perform(get("/application/ACC041")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }

    @Test
    void testGetApplicationByInvalidIdPrefix() throws Exception {
        mockMvc.perform(get("/application/XYZ123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.details").value("Invalid Prefix. ID starts with 'ACC' with numbers"));
    }

    @Test
    void testPostApplicationWithEmptyBody() throws Exception {
        mockMvc.perform(post("/application")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testPostApplicationWithoutPerson() throws Exception {
        mockMvc.perform(post("/application")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\r\n" + //
                                        "\r\n" + //
                                        "\"product_name\": \"platinum\",\r\n" + //
                                        "  \"approved_credit_limit\": 4000,\r\n" + //
                                        "  \"credit_state\": \"regular\",\r\n" + //
                                        "  \"application_state\": \"approve\"\r\n" + //
                                        "}\r\n" + //
                                        ""))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.details").value("person: Person is not declared but is required"));
    }

    @Test
    void testPostApplicationWithWrongDNI() throws Exception {
        mockMvc.perform(post("/application")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\r\n" + //
                                        "  \"person\": {\r\n" + //
                                        "    \"dni\": 778418,\r\n" + //
                                        "    \"name_person\": \"Christian\",\r\n" + //
                                        "    \"last_name_person\": \"Cueva\"\r\n" + //
                                        "  },\r\n" + //
                                        "  \"product_name\": \"platinum\",\r\n" + //
                                        "  \"approved_credit_limit\": 4000,\r\n" + //
                                        "  \"credit_state\": \"regular\",\r\n" + //
                                        "  \"application_state\": \"approve\"\r\n" + //
                                        "}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.details").value("person.dni: dni must have 8 digits"));
    }

    @Test
    void testPostApplicationWithPersonButAnyFields() throws Exception {
        mockMvc.perform(post("/application")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\r\n" + //
                                        "    \"person\":{\r\n" + //
                                        "        \r\n" + //
                                        "    },\r\n" + //
                                        "\"product_name\": \"platinum\",\r\n" + //
                                        "  \"approved_credit_limit\": 4000,\r\n" + //
                                        "  \"credit_state\": \"regular\",\r\n" + //
                                        "  \"application_state\": \"approve\"\r\n" + //
                                        "}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.observation").value("Some Fields aren't declared or failded"));
    }

    @Test
    void testPostApplication() throws Exception {
        mockMvc.perform(post("/application")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\r\n" + //
                                        "  \"person\": {\r\n" + //
                                        "    \"dni\": 72030200,\r\n" + //
                                        "    \"name_person\": \"Juan Lorenzo\",\r\n" + //
                                        "    \"last_name_person\": \"Gutierrez Jorgechagua\"\r\n" + //
                                        "  },\r\n" + //
                                        "  \"product_name\": \"platinum\",\r\n" + //
                                        "  \"approved_credit_limit\": 4000,\r\n" + //
                                        "  \"credit_state\": \"regular\",\r\n" + //
                                        "  \"application_state\": \"approve\"\r\n" + //
                                        "}"))
                .andExpect(status().isCreated());
    }
}
