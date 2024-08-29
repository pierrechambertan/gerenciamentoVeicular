package com.omnilink.veiculosclientesapi.controllers;

import com.omnilink.veiculosclientesapi.domain.cliente.Cliente;
import com.omnilink.veiculosclientesapi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable String cpf) {
        Cliente cliente = clienteService.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.create(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable String cpf, @RequestBody Cliente clienteDetails) {
        Cliente updatedCliente = clienteService.update(cpf, clienteDetails);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deleteCliente(@PathVariable String cpf) {
        clienteService.delete(cpf);
        return ResponseEntity.noContent().build();
    }
}
