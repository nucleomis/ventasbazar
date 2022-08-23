package com.bazar.ventas.DTO;

import lombok.Data;

@Data
public class VentaMayorDto {

    private Long codigoVenta;
    private double total;
    private int cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;
}
