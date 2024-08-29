package com.omnilink.veiculosclientesapi.services;

import com.omnilink.veiculosclientesapi.domain.cliente.Cliente;
import com.omnilink.veiculosclientesapi.repositories.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    @Cacheable("clientes")
    public List<Cliente> findAll() {
        logger.info("Buscando todos os clientes");
        return clienteRepository.findAll();
    }

    @Cacheable(value = "cliente", key = "#cpf")
    public Optional<Cliente> findById(String cpf) {
        logger.debug("Buscando cliente com CPF: {}", cpf);
        return clienteRepository.findById(cpf);
    }

    @Transactional
    @CachePut(value = "cliente", key = "#cliente.cpf")
    public Cliente create(Cliente cliente) {
        logger.info("Criando novo cliente com CPF: {}", cliente.getCpf());
        return clienteRepository.save(cliente);
    }

    @Transactional
    @CachePut(value = "cliente", key = "#cpf")
    public Cliente update(String cpf, Cliente clienteDetails) {
        logger.info("Atualizando cliente com CPF: {}", cpf);
        Cliente cliente = clienteRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setNome(clienteDetails.getNome());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setTelefone(clienteDetails.getTelefone());
        return clienteRepository.save(cliente);
    }

    @Transactional
    @CacheEvict(value = "cliente", key = "#cpf")
    public void delete(String cpf) {
        logger.warn("Deletando cliente com CPF: {}", cpf);
        Cliente cliente = clienteRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
    }
}
