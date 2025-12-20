package com.proyecto.GestionDePedidos.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */

@Getter @Setter
public class DetallePedidoRequestDTO {
    @NotNull
    private Long idProducto;
    @NotNull
    @Min(1)
    private Integer cantidad;
    
    public DetallePedidoRequestDTO() {
    }

    public DetallePedidoRequestDTO(Long idProducto, Integer cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    } 
}
