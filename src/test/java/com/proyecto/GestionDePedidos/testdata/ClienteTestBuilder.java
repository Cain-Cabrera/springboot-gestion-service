package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.models.Cliente;
import com.proyecto.GestionDePedidos.models.Pedido;
import java.util.List;

/**
 *
 * @author Cain
 */
public class ClienteTestBuilder {

    private Long id = 1L;
    private String nombre = "Cain";
    private String apellido = "Cabrera";
    private String dni = "44026015";
    private List<Pedido> pedidos = null;

    private ClienteTestBuilder() {
    }

    public static ClienteTestBuilder unCliente() {
        return new ClienteTestBuilder();
    }

    public ClienteTestBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ClienteTestBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteTestBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public ClienteTestBuilder conDni(String dni) {
        this.dni = dni;
        return this;
    }

    public ClienteTestBuilder conPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
        return this;
    }

    public Cliente build() {
        return new Cliente(id, nombre, apellido, dni, pedidos);
    }
}
