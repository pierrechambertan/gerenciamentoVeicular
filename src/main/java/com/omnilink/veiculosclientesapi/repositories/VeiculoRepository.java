package com.omnilink.veiculosclientesapi.repositories;

import com.omnilink.veiculosclientesapi.domain.veiculo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
}
