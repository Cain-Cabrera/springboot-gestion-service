package com.proyecto.GestionDePedidos.Repository;

import com.proyecto.GestionDePedidos.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Cain
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
