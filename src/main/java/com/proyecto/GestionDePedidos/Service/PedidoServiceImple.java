package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.DetallePedidoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.PedidoRequestDTO;
import com.proyecto.GestionDePedidos.Mapper.PedidoMapper;
import com.proyecto.GestionDePedidos.Repository.ClienteRepository;
import com.proyecto.GestionDePedidos.Repository.PedidoRepository;
import com.proyecto.GestionDePedidos.Repository.ProductoRepository;
import com.proyecto.GestionDePedidos.models.Cliente;
import com.proyecto.GestionDePedidos.models.DetalleDePedido;
import com.proyecto.GestionDePedidos.models.Pedido;
import com.proyecto.GestionDePedidos.models.Producto;
import com.proyecto.GestionDePedidos.validatorService.PedidoValidator;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cain
 */
@Service
public class PedidoServiceImple implements PedidoService{
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoValidator validatorPedido;
    private final PedidoMapper pedidoMapper;
    private final ProductoRepository productoRepository;
    private static final Logger logger = LoggerFactory.getLogger(PedidoServiceImple.class);

    public PedidoServiceImple(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, PedidoValidator validatorPedido, PedidoMapper pedidoMapper, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.validatorPedido = validatorPedido;
        this.pedidoMapper = pedidoMapper;
        this.productoRepository = productoRepository;
    }
   
    @Override
    public Pedido createPedido(PedidoRequestDTO pedidoDto) {
        logger.trace("Se ejecuta createPedido para crear nuevo Pedido asociado a un cliente..");
        validatorPedido.validarAltaPedido(pedidoDto);
        Cliente clienteExistente = clienteRepository.findById(pedidoDto.getIdCliente())
                
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado."));
        Pedido pedido = pedidoMapper.toEntity(pedidoDto,clienteExistente);
        
        List<DetalleDePedido> detalles = new ArrayList<>();
        
        for (DetallePedidoRequestDTO detalleDto : pedidoDto.getDetalles()) {

        Producto producto = productoRepository.findById(detalleDto.getIdProducto())
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        if (producto.getStock() < detalleDto.getCantidad()) {
            throw new IllegalArgumentException("Stock insuficiente para el producto " + producto.getNombre());
        }

        DetalleDePedido detalle = new DetalleDePedido();
        detalle.setPedido(pedido);
        detalle.setProducto(producto);
        detalle.setCantidad(detalleDto.getCantidad());
        detalle.setPrecioUnitario(producto.getPrecio());

        detalles.add(detalle);
        producto.setStock(producto.getStock() - detalleDto.getCantidad());
    }

    pedido.setDetalleDelPedido(detalles);

        return pedidoRepository.save(pedido);
    }
    
    @Override
    public List<Pedido> findAll() {
        logger.trace("Se ejecuta metodo FindAll para traer todos los pedidos..");
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido findById(Long id) {
        logger.trace("Se ejecuta metodo finbyId para traer Pedido por id..");
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El pedido no existe"));
    }

    @Override
    public Pedido updatePedido(PedidoRequestDTO pedidoDto) {
        logger.trace("Se ejecuta updatePedido para actualizar pedido existente..");
        Pedido pedidoAActualizar = pedidoRepository.findById(pedidoDto.getIdCliente())
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
        pedidoMapper.updateEntity(pedidoAActualizar, pedidoDto);
        logger.warn("Puede ser que no se serialize bien el Pedido.. ");
        return pedidoRepository.save(pedidoAActualizar);
    }
    
    @Override
    public void deletePedido(Long id) {
        logger.trace("Se ejecuta deletePedido para borrar Pedido..");
        if (id <= 0) {
            logger.error("ID inválido para borrar Pedido: {}" , id);
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        Pedido pedido = findById(id);
        pedidoRepository.deleteById(id);
        logger.info("Pedido con id {} borrado con exito.. ", id);
    }
    
    
    
}
