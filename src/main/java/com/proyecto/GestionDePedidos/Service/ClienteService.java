package com.proyecto.GestionDePedidos.Service;


import com.proyecto.GestionDePedidos.DTO.ClienteDTO;
import com.proyecto.GestionDePedidos.DTO.ClienteResponseDTO;
import com.proyecto.GestionDePedidos.models.Cliente;
import java.util.List;

/**
 *
 * @author Cain
 */
public interface ClienteService {
    ClienteResponseDTO createCliente(ClienteDTO entidad);
    ClienteResponseDTO updateCliente(Long id, ClienteDTO entidad);
    void deleteCliente (Long id);  
    List<Cliente> findAll();
    ClienteResponseDTO findById(Long id);
    Cliente findByIdEntity(Long id);
}
