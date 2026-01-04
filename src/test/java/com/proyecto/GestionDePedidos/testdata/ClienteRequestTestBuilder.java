package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.DTO.ClienteRequestDTO;

/**
 *
 * @author Cain
 */
public class ClienteRequestTestBuilder {
    private String nombre = "Cain";
    private String apellido = "Cabrera";
    private String dni = "44026015";

    private ClienteRequestTestBuilder() {
    }
    
    public static ClienteRequestTestBuilder unClienteRequest() {
        return new ClienteRequestTestBuilder();
    }
    
    public ClienteRequestTestBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    
    public ClienteRequestTestBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }
    
    public ClienteRequestTestBuilder conDni(String dni) {
        this.dni = dni;
        return this;
    }
    
    public ClienteRequestDTO build() {
        return new ClienteRequestDTO(nombre, apellido, dni);
    }
    
}
