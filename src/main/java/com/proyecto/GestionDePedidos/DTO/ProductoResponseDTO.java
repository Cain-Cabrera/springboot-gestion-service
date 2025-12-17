package com.proyecto.GestionDePedidos.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */
@Setter @Getter
public class ProductoResponseDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private int stock;

    public ProductoResponseDTO() {
    }

    public ProductoResponseDTO(String nombre, Double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }   
}
