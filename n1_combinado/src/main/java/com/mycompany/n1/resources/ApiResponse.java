package com.mycompany.n1.resources;

/**
 * DTO simple para respuestas de error/mensaje en formato JSON.
 * Jackson lo serializa automáticamente como {"mensaje": "..."}
 */
public class ApiResponse {
    private String mensaje;

    public ApiResponse() {}

    public ApiResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}