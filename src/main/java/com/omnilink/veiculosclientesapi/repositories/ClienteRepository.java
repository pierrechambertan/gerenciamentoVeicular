package com.omnilink.veiculosclientesapi.repositories;

import com.omnilink.veiculosclientesapi.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
