package com.bazar.ventas.Service;

import com.bazar.ventas.Models.Cliente;
import com.bazar.ventas.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository repoCliente;

    @Override
    public List<Cliente> getClientes() {
        return (List<Cliente>) repoCliente.findAll();
    }

    @Override
    public void saveCliente(Cliente cliente) {
        repoCliente.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        repoCliente.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        return repoCliente.findById(id).orElse(null);
    }
}
