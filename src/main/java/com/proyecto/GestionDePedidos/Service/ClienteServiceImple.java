package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.ClienteDTO;
import com.proyecto.GestionDePedidos.Mapper.ClienteMapper;
import com.proyecto.GestionDePedidos.Repository.ClienteRepository;
import com.proyecto.GestionDePedidos.validatorService.ClienteValidator;
import com.proyecto.GestionDePedidos.models.Cliente;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cain
 */
@Service
public class ClienteServiceImple implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteValidator clienteValidator;
    private final ClienteMapper clienteMapper;
    private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImple.class);

    public ClienteServiceImple(ClienteRepository clienteRepository, ClienteValidator clienteValidator, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteValidator = clienteValidator;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public Cliente createCliente(ClienteDTO clienteDto) {
        logger.trace("Se ejecuta metodo createCliente para dar de alta una entidad Cliente");
        clienteValidator.validarClienteDTO(clienteDto);
        Cliente cliente = clienteMapper.mapperCreateEntidad(clienteDto);
        logger.info("Cliente dado de alta con exito..");
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, ClienteDTO clienteDto) {
        logger.trace("Se ejecuta updateCliente para actualizar informacion del cliente..");
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado."));
        clienteValidator.validarClienteDTO(clienteDto);
        clienteMapper.mapperUpdateEntidad(clienteDto, clienteExistente);
        logger.info("Cliente con id {} actualizado con exito..", id );
        return clienteRepository.save(clienteExistente);
    }

    @Override
    public void deleteCliente(Long id) {
        logger.trace("Se ejecuta deleteCliente para borrar Cliente..");
        if (id <= 0) {
            logger.error("ID inválido para borrar Cliente: {}" , id);
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        
        Cliente cliente = findById(id);
        clienteRepository.deleteById(id);
        logger.info("Cliente con id {} borrado con exito.. ", id);  
    }

    @Override
    public List<Cliente> findAll() {
        logger.trace("Se ejecuta findAll para mostrar todos los clientes");
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        logger.trace("Se ejecuta medoto findById para buscar un Cliente..");
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}
