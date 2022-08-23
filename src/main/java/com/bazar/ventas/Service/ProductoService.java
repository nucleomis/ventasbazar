package com.bazar.ventas.Service;

import com.bazar.ventas.Models.Producto;
import com.bazar.ventas.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository repoProducto;

    @Override
    public List<Producto> getProductos() {
        return (List<Producto>) repoProducto.findAll();
    }

    @Override
    public void saveProducto(Producto producto) {
        repoProducto.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        repoProducto.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        return repoProducto.findById(id).orElse(null);
    }

    @Override
    public List<Producto> obtenerProductosEscasos() {
        return repoProducto.obtenerProductosEscasos();
    }
}
