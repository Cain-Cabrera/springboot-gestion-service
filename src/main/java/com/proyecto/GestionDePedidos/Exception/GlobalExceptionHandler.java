package com.proyecto.GestionDePedidos.Exception;

import com.proyecto.GestionDePedidos.DTO.ApiResponseError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author Cain
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<ApiResponseError> handleInexistensCliente(ClienteNotFoundException ex,HttpServletRequest request) {
        ApiResponseError responseError = new ApiResponseError(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(), 
                request.getRequestURI(),
                HttpStatus.NOT_FOUND.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
    }
    
    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ApiResponseError> handleInsufficientResources(InsufficientStockException ex, HttpServletRequest request) {
        ApiResponseError responseError = new ApiResponseError(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                request.getRequestURI(),
                HttpStatus.CONFLICT.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseError);
    }
    
   @ExceptionHandler(PedidoNotFoundException.class)
    public ResponseEntity<ApiResponseError> handlePedidoNotFound(PedidoNotFoundException ex,HttpServletRequest request) {
        ApiResponseError error = new ApiResponseError(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            request.getRequestURI(),
            HttpStatus.NOT_FOUND.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<ApiResponseError> handleProductoNotFound(ProductoNotFoundException ex,HttpServletRequest request) {
        ApiResponseError error = new ApiResponseError(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            request.getRequestURI(),
            HttpStatus.NOT_FOUND.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<ApiResponseError> handleInvalidId(InvalidIdException ex,HttpServletRequest request) {
        ApiResponseError error = new ApiResponseError(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            request.getRequestURI(),
            HttpStatus.BAD_REQUEST.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }




    
    
    
}
