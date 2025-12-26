package com.proyecto.GestionDePedidos.DTO;

import java.time.LocalDateTime;
import java.util.Map;
/**
 *
 * @author Cain
 */
public class ApiResponseError {
    private int statusCode;
    private String message;
    private String path;
    private String error;
    private LocalDateTime timestamp;
    private Map<String, String> validationErrors;

    public ApiResponseError(int statusCode, String message, String path, String error) {
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponseError(int statusCode,String message, String path,String error,Map<String, String> validationErrors) {
        this(statusCode, message, path, error);
        this.validationErrors = validationErrors;
    }
    
    public ApiResponseError() {
    } 
}
