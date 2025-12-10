package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.PedidoRequestDTO;
import com.proyecto.GestionDePedidos.models.Pedido;
import java.util.List;

/**
 *
 * @author Cain
 */
public interface PedidoService {
    Pedido createPedido(PedidoRequestDTO pedidoDto);
    List<Pedido> findAll();
    Pedido findById(Long id);
    Pedido updatePedido(PedidoRequestDTO pedidoDto);
    void deletePedido(Long id);  
}
