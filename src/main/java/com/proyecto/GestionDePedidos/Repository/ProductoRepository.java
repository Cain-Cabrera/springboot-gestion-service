package com.proyecto.GestionDePedidos.Repository;

import com.proyecto.GestionDePedidos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cain
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{}
