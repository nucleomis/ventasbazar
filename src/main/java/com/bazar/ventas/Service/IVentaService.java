package com.bazar.ventas.Service;

import com.bazar.ventas.Models.Producto;
import com.bazar.ventas.Models.Venta;

import java.util.Date;
import java.util.List;

public interface IVentaService {

    public Venta findById(Long id);
    public List<Venta> getVentas();
    public void saveVenta(Venta venta);
    public void deleteVenta(Long id);
    public void editVenta(Venta venta);
    public List<Producto> getProductosDeUnaVenta(Long codigo_venta);

    public List<Object[]> obtenerVentasPorFecha(Date fechaVenta);

    public Venta obtenerVentaMayor();
}
