package com.proyecto.GestionDePedidos.DTO;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */
@Setter @Getter
public class PedidoRequestDTO {

    @NotNull
    private Long idCliente;
    @NotNull
    private List<DetallePedidoRequestDTO> detalles;
    
    public PedidoRequestDTO() {
    }

    public PedidoRequestDTO(Long idCliente, Long idProducto, List<DetallePedidoRequestDTO> detalles) {
        this.idCliente = idCliente;
        this.detalles = detalles;
    }
    
   
}
