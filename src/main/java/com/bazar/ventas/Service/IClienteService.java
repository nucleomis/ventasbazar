package com.bazar.ventas.Service;

import com.bazar.ventas.Models.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getClientes();
    public void saveCliente(Cliente cliente);
    public void deleteCliente(Long id);
    public Cliente findCliente(Long id);
}
