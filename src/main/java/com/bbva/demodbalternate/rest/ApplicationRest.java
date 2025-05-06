package com.bbva.demodbalternate.rest;

import com.bbva.demodbalternate.dtos.ApplicationDTO;
import com.bbva.demodbalternate.exceptions.InvalidIdPrefixException;
import com.bbva.demodbalternate.model.Application;
import com.bbva.demodbalternate.model.Person;
import com.bbva.demodbalternate.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/application")
public class ApplicationRest {
    
    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    private ResponseEntity<List<Application>> getAllApplications() {
        List<Application> allRequest = applicationService.findAll();
        if (allRequest.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(allRequest);
        }
        
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getApplicationById(@PathVariable String id) throws InvalidIdPrefixException{
        if (!id.matches("^ACC\\d+$")) {
            throw new InvalidIdPrefixException();
        }
        Application someApplication = applicationService.findById(id).orElseThrow(() -> new NoSuchElementException());
        return ResponseEntity.ok(someApplication);
    }

    @PostMapping(consumes = "application/json")
    private ResponseEntity<Map<String,Object>> saveApplication (@Valid @RequestBody ApplicationDTO applicationDTO) {
        
        Map<String, Object> response = new HashMap<>();
        Application applicationNew = new Application();
        applicationNew.setId("");
        Person personNew = new Person();


        personNew.setDni(applicationDTO.getPerson().getDni());
        personNew.setName_person(applicationDTO.getPerson().getName_person());
        personNew.setLast_name_person(applicationDTO.getPerson().getLast_name_person());
        applicationNew.setPerson(personNew);
        applicationNew.setProduct_name(applicationDTO.getProduct_name());
        applicationNew.setApproved_credit_limit(applicationDTO.getApproved_credit_limit());
        applicationNew.setCredit_state(applicationDTO.getCredit_state());
        applicationNew.setApplication_state(applicationDTO.getApplication_state());
        applicationService.save(applicationNew);
        response.put("respuesta", 201);
        response.put("observación", "generado correctamente");
        response.put("detalle",applicationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

}
