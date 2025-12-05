package com.proyecto.GestionDePedidos.DTO;

import com.proyecto.GestionDePedidos.models.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cain
 */

@Setter @Getter
public class ClienteDTO {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String apellido;
    
    @Size(min = 8,max = 8)
    private String dni;

    public ClienteDTO(Cliente cliente) {
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.dni = cliente.getDni();
    }

}
