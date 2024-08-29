package com.omnilink.veiculosclientesapi.services;

import com.omnilink.veiculosclientesapi.domain.cliente.Cliente;
import com.omnilink.veiculosclientesapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(String cpf) {
        return clienteRepository.findById(cpf);
    }

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(String cpf, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setNome(clienteDetails.getNome());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setTelefone(clienteDetails.getTelefone());
        return clienteRepository.save(cliente);
    }

    public void delete(String cpf) {
        Cliente cliente = clienteRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
    }
}
