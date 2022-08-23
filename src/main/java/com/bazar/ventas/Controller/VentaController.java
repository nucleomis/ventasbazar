package com.bazar.ventas.Controller;

import com.bazar.ventas.DTO.TotalVentasDto;
import com.bazar.ventas.DTO.VentaMayorDto;
import com.bazar.ventas.Models.Producto;
import com.bazar.ventas.Models.Venta;
import com.bazar.ventas.Service.ProductoService;
import com.bazar.ventas.Service.VentaService;
import com.bazar.ventas.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<Response> crearVenta(@RequestBody Venta venta) {
        venta.setFechaVenta(new java.sql.Date(System.currentTimeMillis()));
        int total = 0;
        for (Producto pro: venta.getProductoList()) {
            total += pro.getCosto();
        }
        venta.setTotal(total);
        ventaService.saveVenta(venta);
        return ResponseEntity.ok(new Response("Ok", venta));
    }

    @GetMapping("")
    public ResponseEntity<Response> listarVentas() {
        return ResponseEntity.ok(new Response("Ok", ventaService.getVentas()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> listarVenta(@PathVariable Long id) {
        return ResponseEntity.ok(new Response("Ok", ventaService.findById(id)));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Response> eliminarVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
        return ResponseEntity.ok(new Response("Ok", null));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Response> actualizarVenta(@PathVariable Long id,@RequestBody Venta venta) {
        venta.setCodigoVenta(id);
        ventaService.saveVenta(venta);
        return ResponseEntity.ok(new Response("Ok", venta));
    }

    @GetMapping("/productos/{codigo_venta}")
    public ResponseEntity<Response> listarProductosDeUnaVenta(@PathVariable Long codigo_venta) {
        return ResponseEntity.ok(new Response("Ok", ventaService.getProductosDeUnaVenta(codigo_venta)));
    }

    @GetMapping("/fecha/{fecha_venta}")
    public ResponseEntity<Response> listarVentasPorFecha(@PathVariable String fecha_venta) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd");
        Date fecha = java.sql.Date.valueOf(LocalDate.parse(fecha_venta, formato));

        TotalVentasDto totalVentasDto = new TotalVentasDto();
        List<Object[]> ventas = ventaService.obtenerVentasPorFecha(fecha);

        totalVentasDto.setTotalVentas(ventas.get(0)[1]);
        totalVentasDto.setCantidadVentas(ventas.get(0)[0]);

        return ResponseEntity.ok(new Response("Ok", totalVentasDto));
    }

    @GetMapping("/mayor_ventas")
    public ResponseEntity<Response> obtenerVentaMayor() {
        Venta venta = ventaService.obtenerVentaMayor();
        VentaMayorDto ventaMayorDto = new VentaMayorDto();

        ventaMayorDto.setCodigoVenta(venta.getCodigoVenta());
        ventaMayorDto.setNombreCliente(venta.getClienteidCliente().getNombre());
        ventaMayorDto.setApellidoCliente(venta.getClienteidCliente().getApellido());
        ventaMayorDto.setCantidadProductos(venta.getProductoList().size());
        ventaMayorDto.setTotal(venta.getTotal());

        return ResponseEntity.ok(new Response("Ok", ventaMayorDto));
    }

}
