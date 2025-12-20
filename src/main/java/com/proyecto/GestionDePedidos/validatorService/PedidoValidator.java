package com.proyecto.GestionDePedidos.validatorService;

import com.proyecto.GestionDePedidos.DTO.PedidoRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cain
 */
@Component
public class PedidoValidator {
    private static final Logger logger = LoggerFactory.getLogger(PedidoValidator.class);
    
    public void validarAltaPedido(PedidoRequestDTO pedidoDto) { 
        if (pedidoDto.getIdCliente() <= 0) {
            logger.error("El ID llego incorrecto..");
            throw new IllegalArgumentException("El id no puede ser negativo..");
        }
        
        if (pedidoDto.getDetalles() == null) {
            logger.error("Los detalles llegaron sin id y sin cantidad");
            throw new IllegalArgumentException("Los detalles no puden llegar vacios");
        }
    }
}
