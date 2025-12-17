package com.proyecto.GestionDePedidos.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */

@Setter @Getter
public class ClienteRequestDTO {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @Size(min = 8,max = 8)
    private String dni;

    public ClienteRequestDTO(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    

}
