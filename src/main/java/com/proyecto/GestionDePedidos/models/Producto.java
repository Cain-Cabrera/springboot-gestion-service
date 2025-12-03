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
@Setter @Getter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idProducto;
    
    private String nombre;
    private Double precio;
    private int stock;
    
    @OneToMany(mappedBy = "producto")
    private List<DetalleDePedido> detalles;
    
    
    public Producto() {
    }
    
    public Producto(Long idProducto, String nombre, Double precio, Integer stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    
}
