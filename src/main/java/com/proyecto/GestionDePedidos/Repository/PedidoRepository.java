package com.proyecto.GestionDePedidos.Repository;

import com.proyecto.GestionDePedidos.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cain
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
