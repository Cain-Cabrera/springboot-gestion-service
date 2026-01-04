package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.ClienteRequestDTO;
import com.proyecto.GestionDePedidos.DTO.ClienteResponseDTO;
import com.proyecto.GestionDePedidos.Mapper.ClienteMapper;
import com.proyecto.GestionDePedidos.Repository.ClienteRepository;
import com.proyecto.GestionDePedidos.models.Cliente;
import com.proyecto.GestionDePedidos.testdata.ClienteRequestTestBuilder;
import com.proyecto.GestionDePedidos.testdata.ClienteResponseTestBuilder;
import com.proyecto.GestionDePedidos.testdata.ClienteTestBuilder;
import com.proyecto.GestionDePedidos.validatorService.ClienteValidator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Cain
 */
@ExtendWith(MockitoExtension.class)
public class ClienteServiceImpleTest {

    @Mock
    private ClienteRepository clienteRepository;
    
    @Mock
    private ClienteMapper clienteMapper;
    
    @Mock
    private ClienteValidator clienteValidator;
    
    @InjectMocks
    private ClienteServiceImple clienteServiceImple;

    
    @Test
    void creatCliente_clienteCreado_siEsValido() {
        Cliente cliente = ClienteTestBuilder.unCliente()
                .conNombre("Cabrera")
                .conApellido("Cabrera")
                .conDni("440206015")
                .conPedidos(null)
                .build();
        
        ClienteRequestDTO clienteRequest = ClienteRequestTestBuilder.unClienteRequest()
                .conNombre("Cain")
                .conApellido("Cabrera")
                .conDni("44206015")
                .build();
        
        ClienteResponseDTO clienteResponse = ClienteResponseTestBuilder.unClienteResponse()
                .conNombre("Cain")
                .conApellido("Cabrera")
                .conId(1L)
                .build();
        
        when(clienteMapper.mapperCreateEntidad(clienteRequest))
                .thenReturn(cliente);
        when(clienteMapper.toResponse(cliente))
                .thenReturn(clienteResponse);
        when(clienteRepository.save(cliente))
                .thenReturn(cliente);
        
        ClienteResponseDTO resultado = clienteServiceImple.createCliente(clienteRequest);
        
        assertNotNull(resultado);
        assertEquals("Cabrera", resultado.getApellido());
        assertEquals("Cain", resultado.getNombre());
        
        verify(clienteRepository).save(cliente);
    }
    
    @Test
    void creatCliente_clienteNoDadoDeAlta_siNoEsValido() {
        ClienteRequestDTO clienteRequest = ClienteRequestTestBuilder.unClienteRequest()
                .conNombre(null)
                .build();

        assertThrows(IllegalArgumentException.class, () -> {
            clienteServiceImple.createCliente(clienteRequest);
        }); 
    }
}
