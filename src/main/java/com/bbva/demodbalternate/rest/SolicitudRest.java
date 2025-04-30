package com.bbva.demodbalternate.rest;

import com.bbva.demodbalternate.dtos.SolicitudDTO;
import com.bbva.demodbalternate.model.Solicitud;
import com.bbva.demodbalternate.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/solicitud")
public class SolicitudRest {
    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    private ResponseEntity<List<Solicitud>> getAllSolicitudes() {
        return ResponseEntity.ok(solicitudService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Solicitud> getSolicitudById(@PathVariable String id){
        Optional<Solicitud> solicitud = solicitudService.findById(id);
        if(solicitud.isPresent()){
            return ResponseEntity.ok(solicitud.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = "application/json")
    private ResponseEntity<Map<String,Object>> saveSolicitud (@RequestBody SolicitudDTO solicitudDTO){
        Solicitud solicitud = new Solicitud();
        solicitud.setTit_nombres(solicitudDTO.tit_nombres);
        solicitud.setTit_app(solicitudDTO.tit_app);
        solicitud.setTit_apm(solicitudDTO.tit_apm);
        solicitud.setTit_dni(solicitudDTO.tit_dni);
        solicitud.setProducto(solicitudDTO.producto);
        solicitud.setLinea_aprobada(solicitudDTO.linea_aprobada);
        solicitud.setStatus_crediticio(solicitudDTO.status_crediticio);
        solicitud.setStatus_solicitud(solicitudDTO.status_solicitud);
        Map<String, Object> response = new HashMap<>();
        try {
            Solicitud savedSolicitud = solicitudService.save(solicitud);

            response.put("respuesta", 201);
            response.put("observación", "generado correctamente");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){

            response.put("respuesta", 400);
            response.put("observación", "generado correctamente");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

    }

}
