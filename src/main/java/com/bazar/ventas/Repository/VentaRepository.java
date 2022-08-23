package com.bazar.ventas.Repository;

import com.bazar.ventas.Models.Producto;
import com.bazar.ventas.Models.Venta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface VentaRepository extends CrudRepository<Venta, Long> {

    List<Producto> findByCodigoVenta(Long codigoVenta);

    @Query(value = "SELECT count(v) as cantidadVentas, sum(v.total) as totalVentas  FROM Venta v WHERE v.fechaVenta=?1")
    List<Object[]> obtenerVentasPorFecha(Date fechaVenta);

    @Query(value = "SELECT v FROM Venta v where v.total = (SELECT max(v.total) FROM Venta v)")
    Venta obtenerVentaMayor();
}

