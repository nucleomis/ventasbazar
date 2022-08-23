package com.bazar.ventas.Controller;


import com.bazar.ventas.Models.Cliente;
import com.bazar.ventas.Service.ClienteService;
import com.bazar.ventas.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<Response> crearCliente(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);
        return ResponseEntity.ok(new Response("Ok", cliente));
    }

    @GetMapping("")
    public ResponseEntity<Response> listarClientes() {
        return ResponseEntity.ok(new Response("Ok", clienteService.getClientes()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> listarCliente(@PathVariable Long id) {
        return ResponseEntity.ok(new Response("Ok", clienteService.findCliente(id)));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Response> eliminarCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.ok(new Response("Ok", null));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Response> actualizarCliente(@PathVariable Long id,@RequestBody Cliente cliente) {
        cliente.setIdCliente(id);
        clienteService.saveCliente(cliente);
        return ResponseEntity.ok(new Response("Ok", cliente));
    }

}
