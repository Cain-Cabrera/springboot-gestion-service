package com.proyecto.GestionDePedidos.DTO;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */
@Setter @Getter
public class ProductoRequestDTO {
    @NotBlank
    @Size(min = 3)
    private String nombre;
    @NotNull
    @Positive
    @DecimalMax(value = "1000000.00")
    private double precio;
    @NotNull
    @Positive
    private int stock;

    public ProductoRequestDTO(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
}
