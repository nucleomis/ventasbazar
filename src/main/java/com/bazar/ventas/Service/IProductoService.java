package com.bazar.ventas.Service;

import com.bazar.ventas.Models.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> getProductos();
    public void saveProducto(Producto producto);
    public void deleteProducto(Long id);
    public Producto findProducto(Long id);

    public List<Producto> obtenerProductosEscasos();

}
