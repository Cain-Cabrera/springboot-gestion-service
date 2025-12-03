/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.GestionDePedidos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

/**
 *
 * @author Cain
 */
@Getter
@Entity
public class DetalleDePedido {
    @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private Integer cantidad;
    private Double precioUnitario;
    
    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    public DetalleDePedido() {
    }

    public DetalleDePedido(Long id, Integer cantidad, Double precioUnitario) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    
    
    
    
}
