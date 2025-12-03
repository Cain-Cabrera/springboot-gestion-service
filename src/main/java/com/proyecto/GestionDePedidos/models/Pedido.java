package com.proyecto.GestionDePedidos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */
@Setter @Getter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idPedido;
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;
    
    @ManyToOne
    private Cliente cliente;
    
    @OneToMany
    private List<DetalleDePedido> detalleDelPedido;

    public Pedido() {
    }

    public Pedido(Long idPedido, LocalDate fecha, EstadoPedido estado, Cliente cliente, List<DetalleDePedido> detalleDelPedido) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.detalleDelPedido = detalleDelPedido;
    }

    
    
    
    
    
    
    
}
