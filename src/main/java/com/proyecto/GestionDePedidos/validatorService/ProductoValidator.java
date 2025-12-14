package com.proyecto.GestionDePedidos.validatorService;

import com.proyecto.GestionDePedidos.DTO.ProductoRequestDTO;

/**
 *
 * @author Cain
 */
public class ProductoValidator {
    public void validarAlta(ProductoRequestDTO productoDTO) {
        if (productoDTO.getNombre() == null || productoDTO.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }

        if (productoDTO.getNombre().length() < 3) {
            throw new IllegalArgumentException("El nombre del producto debe tener al menos 3 caracteres");
        }

        if (productoDTO.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        if (productoDTO.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }
}
