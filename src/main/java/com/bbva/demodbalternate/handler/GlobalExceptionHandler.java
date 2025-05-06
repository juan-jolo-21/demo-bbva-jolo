package com.bbva.demodbalternate.handler;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bbva.demodbalternate.exceptions.InvalidIdPrefixException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, Object>> handleNoSuchElementException(NoSuchElementException ex) {
        Map<String, Object> response = new LinkedHashMap();
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("value","not found");
        response.put("observation", "not found application or bad wright");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleNoFieldsException(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new LinkedHashMap();

        // Recoger los mensajes de error de cada campo inválido
        String errores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("value", "bad request");
        response.put("observation", "Some Fields aren't declared or failded");
        response.put("details", errores);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidIdPrefixException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidIdPrefixException(InvalidIdPrefixException ex) {
        Map<String, Object> response = new LinkedHashMap();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("value", "bad request");
        response.put("details", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("value", "bad request");
        response.put("observation", "an error has occurred");
        response.put("details", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
