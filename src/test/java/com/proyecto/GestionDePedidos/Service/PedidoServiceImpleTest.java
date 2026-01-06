package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.PedidoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.PedidoResponseDTO;
import com.proyecto.GestionDePedidos.Exception.InvalidIdException;
import com.proyecto.GestionDePedidos.Exception.PedidoNotFoundException;
import com.proyecto.GestionDePedidos.Mapper.PedidoMapper;
import com.proyecto.GestionDePedidos.Repository.ClienteRepository;
import com.proyecto.GestionDePedidos.Repository.PedidoRepository;
import com.proyecto.GestionDePedidos.Repository.ProductoRepository;
import com.proyecto.GestionDePedidos.models.Cliente;
import com.proyecto.GestionDePedidos.models.Pedido;
import com.proyecto.GestionDePedidos.models.Producto;
import com.proyecto.GestionDePedidos.testdata.ClienteTestBuilder;
import com.proyecto.GestionDePedidos.testdata.PedidoRequestTestBuilder;
import com.proyecto.GestionDePedidos.testdata.PedidoResponseTestBuilder;
import com.proyecto.GestionDePedidos.testdata.PedidoTestBuilder;
import com.proyecto.GestionDePedidos.testdata.ProductoTestBuilder;
import com.proyecto.GestionDePedidos.validatorService.PedidoValidator;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Cain
 */
@ExtendWith(MockitoExtension.class)
class PedidoServiceImpleTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private PedidoValidator pedidoValidator;

    @Mock
    private PedidoMapper pedidoMapper;

    @InjectMocks
    private PedidoServiceImple pedidoService;

    @Test
    void createPedido_PedidoCreado_siDatosValidos() {
    PedidoRequestDTO request = PedidoRequestTestBuilder.unPedidoRequest()
            .conIdCliente(1L)
            .build();

    Cliente cliente = ClienteTestBuilder.unCliente()
            .conId(1L)
            .build();

    Producto producto = ProductoTestBuilder.unProducto()
            .conId(1L)
            .conStock(10)
            .conPrecio(200.0)
            .build();

        Pedido pedidoGuardado = new Pedido();
        pedidoGuardado.setIdPedido(1L);
        pedidoGuardado.setCliente(cliente);

        PedidoResponseDTO responseEsperada = new PedidoResponseDTO();
        responseEsperada.setIdPedido(1L);

        when(clienteRepository.findById(1L))
                .thenReturn(Optional.of(cliente));

        when(productoRepository.findById(1L))
                .thenReturn(Optional.of(producto));

        when(pedidoRepository.save(any(Pedido.class)))
                .thenReturn(pedidoGuardado);

        when(pedidoMapper.toResponse(pedidoGuardado))
                .thenReturn(responseEsperada);

        PedidoResponseDTO response = pedidoService.createPedido(request);

        assertNotNull(response);
        assertEquals(1L, response.getIdPedido());

        verify(pedidoValidator).validarAltaPedido(request);
        verify(clienteRepository).findById(1L);
        verify(productoRepository).findById(1L);
        verify(pedidoRepository).save(any(Pedido.class));
    }

    @Test
    void createPedido_Error_siClienteNoExiste() {
        PedidoRequestDTO request = PedidoRequestTestBuilder.unPedidoRequest()
                .conIdCliente(99L)
                .build();

        when(clienteRepository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(PedidoNotFoundException.class, () -> {
            pedidoService.createPedido(request);
        });

        verify(clienteRepository).findById(99L);
        verify(pedidoRepository, never()).save(any());
    }
    
    @Test
    void findAll_PedidosEncontrados() {
        Pedido pedido1 = PedidoTestBuilder.unPedido().conIdPedido(1L).build();
        Pedido pedido2 = PedidoTestBuilder.unPedido().conIdPedido(2L).build();

        List<Pedido> pedidos = List.of(pedido1, pedido2);

        PedidoResponseDTO response1 = PedidoResponseTestBuilder.unPedidoResponse()
                .conIdPedido(1L)
                .build();

        PedidoResponseDTO response2 = PedidoResponseTestBuilder.unPedidoResponse()
                .conIdPedido(2L)
                .build();

        when(pedidoRepository.findAll())
                .thenReturn(pedidos);

        when(pedidoMapper.toResponseList(pedidos))
                .thenReturn(List.of(response1, response2));

        List<PedidoResponseDTO> resultado = pedidoService.findAll();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());

        verify(pedidoRepository).findAll();
        verify(pedidoMapper).toResponseList(pedidos);
    }
    
    @Test
    void findById_PedidoEncontrado_siIdExiste() {
        Long idBusqueda = 1L;

        Pedido pedido = PedidoTestBuilder.unPedido()
                .conIdPedido(idBusqueda)
                .build();

        PedidoResponseDTO response = PedidoResponseTestBuilder.unPedidoResponse()
                .conIdPedido(idBusqueda)
                .build();

        when(pedidoRepository.findById(idBusqueda))
                .thenReturn(Optional.of(pedido));

        when(pedidoMapper.toResponse(pedido))
                .thenReturn(response);

        PedidoResponseDTO resultado = pedidoService.findById(idBusqueda);

        assertNotNull(resultado);
        assertEquals(idBusqueda, resultado.getIdPedido());

        verify(pedidoRepository).findById(idBusqueda);
        verify(pedidoMapper).toResponse(pedido);
    }
    
    @Test
    void findById_Error_siIdNoExiste() {
        Long idBusqueda = 99L;

        when(pedidoRepository.findById(idBusqueda))
                .thenReturn(Optional.empty());

        assertThrows(InvalidIdException.class, () -> {
            pedidoService.findById(idBusqueda);
        });

        verify(pedidoRepository).findById(idBusqueda);
    }
    
    @Test
    void deletePedido_PedidoBorrado_siIdExiste() {
        Long idBusqueda = 1L;

        Pedido pedido = PedidoTestBuilder.unPedido()
                .conIdPedido(idBusqueda)
                .build();

        when(pedidoRepository.findById(idBusqueda))
                .thenReturn(Optional.of(pedido));

        pedidoService.deletePedido(idBusqueda);

        verify(pedidoRepository).findById(idBusqueda);
        verify(pedidoRepository).deleteById(idBusqueda);
    }

    @Test
    void deletePedido_Error_siIdInvalido() {
        Long idInvalido = 0L;

        assertThrows(InvalidIdException.class, () -> {
            pedidoService.deletePedido(idInvalido);
        });

        verifyNoInteractions(pedidoRepository);
    }
    
    @Test
    void deletePedido_Error_siIdNoExiste() {
        Long idBusqueda = 50L;

        when(pedidoRepository.findById(idBusqueda))
                .thenReturn(Optional.empty());

        assertThrows(InvalidIdException.class, () -> {
            pedidoService.deletePedido(idBusqueda);
        });

        verify(pedidoRepository).findById(idBusqueda);
        verify(pedidoRepository, never()).deleteById(anyLong());
    }
}
