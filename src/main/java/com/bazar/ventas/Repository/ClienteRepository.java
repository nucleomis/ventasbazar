package com.bazar.ventas.Repository;

import com.bazar.ventas.Models.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findByNombre(String nombre);

}

