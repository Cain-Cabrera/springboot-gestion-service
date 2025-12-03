package com.proyecto.GestionDePedidos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */
@Setter
@Getter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idCliente;
    private String nombre;
    private String apellido;
    private int dni;
    @OneToMany
    @JoinColumn(referencedColumnName = "id_cliente")
    private List<Pedido> listaDePedidos;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nombre, String apellido, int dni, List<Pedido> listaDePedidos) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.listaDePedidos = listaDePedidos;
    }
    
    
}
    

