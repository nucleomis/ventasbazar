package com.bazar.ventas.Service;

import com.bazar.ventas.Models.Producto;
import com.bazar.ventas.Models.Venta;
import com.bazar.ventas.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;


    @Override
    public Venta findById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Venta> getVentas() {
        return (List<Venta>) ventaRepository.findAll();
    }

    @Override
    public void saveVenta(Venta venta) {

    }

    @Override
    public void deleteVenta(Long id) {

    }

    @Override
    public void editVenta(Venta venta) {

    }

    @Override
    public List<Producto> getProductosDeUnaVenta(Long codigo_venta) {
        return ventaRepository.findByCodigoVenta(codigo_venta);
    }

    @Override
    public List<Object[]> obtenerVentasPorFecha(Date fechaVenta) {
        return ventaRepository.obtenerVentasPorFecha(fechaVenta);
    }


    @Override
    public Venta obtenerVentaMayor() {
        return ventaRepository.obtenerVentaMayor();
    }
}
