package com.mycompany.n1.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Manejo centralizado de excepciones para toda la API REST.
 * Cualquier RuntimeException no capturada explícitamente en el
 * controller (ej. fallo de conexión a MySQL) cae aquí y se
 * traduce en un 500 con JSON controlado, en vez de un error crudo.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse> manejarErroresGenericos(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("Error interno del servidor: " + e.getMessage()));
    }
}