package com.bazar.ventas.Controller;


import com.bazar.ventas.Models.Producto;
import com.bazar.ventas.Service.ProductoService;
import com.bazar.ventas.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<Response> crearProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);

        return ResponseEntity.ok(new Response("Ok", producto));
    }

    @GetMapping("")
    public ResponseEntity<Response> listarProductos() {
        return ResponseEntity.ok(new Response("Ok", productoService.getProductos()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> listarProducto(@PathVariable Long id) {
        return ResponseEntity.ok(new Response("Ok", productoService.findProducto(id)));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Response> eliminarProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return ResponseEntity.ok(new Response("Ok", null));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Response> actualizarProducto(@PathVariable Long id,@RequestBody Producto producto) {
        producto.setCodigoProducto(id);
        productoService.saveProducto(producto);
        return ResponseEntity.ok(new Response("Ok", producto));
    }

    @GetMapping("/falta_stock")
    public ResponseEntity<Response> listarProductosFaltaStock() {
        return ResponseEntity.ok(new Response("Ok", productoService.obtenerProductosEscasos()));
    }
}
