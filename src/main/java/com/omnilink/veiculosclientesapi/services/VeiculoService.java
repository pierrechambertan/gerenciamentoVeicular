package com.omnilink.veiculosclientesapi.services;

import com.omnilink.veiculosclientesapi.domain.veiculo.Veiculo;
import com.omnilink.veiculosclientesapi.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> findById(String placa) {
        return veiculoRepository.findById(placa);
    }

    public Veiculo create(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo update(String placa, Veiculo veiculoDetails) {
        Veiculo veiculo = veiculoRepository.findById(placa)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
        veiculo.setMarca(veiculoDetails.getMarca());
        veiculo.setModelo(veiculoDetails.getModelo());
        veiculo.setAno(veiculoDetails.getAno());
        veiculo.setCliente(veiculoDetails.getCliente());
        return veiculoRepository.save(veiculo);
    }

    public void delete(String placa) {
        Veiculo veiculo = veiculoRepository.findById(placa)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
        veiculoRepository.delete(veiculo);
    }
}
