package com.proyecto.GestionDePedidos.Validator;

import com.proyecto.GestionDePedidos.DTO.ClienteDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cain
 */
public class ClienteValidator {
    private static final Logger logger = LoggerFactory.getLogger(ClienteValidator.class);
    
    public void validarAlta(ClienteDTO clienteDto) {
        logger.trace("Se ejecuta validarAlta para validar Logica de negocio..");
        
        if (clienteDto == null) {
            logger.error("El cliente llego vacio");
            throw new IllegalArgumentException("Cliente llego vacio, fallo la transaccion");
        }
        
        if (clienteDto.getNombre() == null || clienteDto.getNombre().isBlank()) {
            logger.error("El nombre del cliente llego vacio");
            throw new IllegalArgumentException("Cliente sin nombre..");
        }
        
        if (clienteDto.getApellido() == null || clienteDto.getApellido().isBlank()) {
            logger.error("El apellido del cliente llego vacio");
            throw new IllegalArgumentException("Cliente sin apellido..");
        }
        
        if (clienteDto.getDni().isBlank() || clienteDto.getDni().length() != 8) {
            logger.error("El dni del cliente llego vacio o con formato incorrecto");
            throw new IllegalArgumentException("Cliente con dni erroneo..");
        }
    }
}
