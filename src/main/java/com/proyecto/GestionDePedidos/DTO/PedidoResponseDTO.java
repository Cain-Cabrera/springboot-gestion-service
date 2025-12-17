package com.proyecto.GestionDePedidos.DTO;

import com.proyecto.GestionDePedidos.models.EstadoPedido;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */

@Setter @Getter
public class PedidoResponseDTO {

    private Long idPedido;
    private LocalDate fecha;
    private EstadoPedido estado;
    private Long idCliente;

    public PedidoResponseDTO() {
    }  

    public PedidoResponseDTO(Long idPedido, LocalDate fecha, EstadoPedido estado, Long idCliente) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.estado = estado;
        this.idCliente = idCliente;
    }
}
