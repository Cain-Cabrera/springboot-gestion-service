package com.proyecto.GestionDePedidos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String dni;
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> listaDePedidos;

    public Cliente() {
    }

    public Cliente(Long idCliente, String nombre, String apellido, String dni, List<Pedido> listaDePedidos) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.listaDePedidos = listaDePedidos;
    }
}
    

