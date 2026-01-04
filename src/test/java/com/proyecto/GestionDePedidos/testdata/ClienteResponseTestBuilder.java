package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.DTO.ClienteResponseDTO;

/**
 *
 * @author Cain
 */
public class ClienteResponseTestBuilder {

    private Long id = 1L;
    private String nombre = "Cain";
    private String apellido = "Cabrera";

    private ClienteResponseTestBuilder() {
    }

    public static ClienteResponseTestBuilder unClienteResponse() {
        return new ClienteResponseTestBuilder();
    }

    public ClienteResponseTestBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ClienteResponseTestBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteResponseTestBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public ClienteResponseDTO build() {
        return new ClienteResponseDTO(id, nombre, apellido);
    }
}
