package com.bazar.ventas.Repository;

import com.bazar.ventas.Models.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    @Query(value = "SELECT p FROM Producto p WHERE p.cantidadDisponible < 5")
    public List<Producto> obtenerProductosEscasos();

}

