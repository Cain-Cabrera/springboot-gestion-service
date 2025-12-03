package com.proyecto.GestionDePedidos.models;
/**
 *
 * @author Cain
 */
public enum EstadoPedido {
    PENDIENTE("Pendiente"),
    EN_PREPARACION("En preparacion"),
    EN_CAMINO("En camino"),
    ENTREGADO("Entregado"),
    CANCELADO("Pedido cancelado");
    
    private final String descripcion;

    private EstadoPedido(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    
    
    
    
    
    
}





