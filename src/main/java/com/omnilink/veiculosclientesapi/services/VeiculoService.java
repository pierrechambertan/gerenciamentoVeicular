package com.omnilink.veiculosclientesapi.services;

import com.omnilink.veiculosclientesapi.domain.veiculo.Veiculo;
import com.omnilink.veiculosclientesapi.repositories.VeiculoRepository;
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
public class VeiculoService {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoService.class);

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Cacheable("veiculos")
    public List<Veiculo> findAll() {
        logger.info("Buscando todos os veículos");
        return veiculoRepository.findAll();
    }

    @Cacheable(value = "veiculo", key = "#placa")
    public Optional<Veiculo> findById(String placa) {
        logger.debug("Buscando veículo com placa: {}", placa);
        return veiculoRepository.findById(placa);
    }

    @Transactional
    @CachePut(value = "veiculo", key = "#veiculo.placa")
    public Veiculo create(Veiculo veiculo) {
        logger.info("Criando novo veículo com placa: {}", veiculo.getPlaca());
        return veiculoRepository.save(veiculo);
    }

    @Transactional
    @CachePut(value = "veiculo", key = "#placa")
    public Veiculo update(String placa, Veiculo veiculoDetails) {
        logger.info("Atualizando veículo com placa: {}", placa);
        Veiculo veiculo = veiculoRepository.findById(placa)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        veiculo.setMarca(veiculoDetails.getMarca());
        veiculo.setModelo(veiculoDetails.getModelo());
        veiculo.setAno(veiculoDetails.getAno());
        veiculo.setCliente(veiculoDetails.getCliente());
        return veiculoRepository.save(veiculo);
    }

    @Transactional
    @CacheEvict(value = "veiculo", key = "#placa")
    public void delete(String placa) {
        logger.warn("Deletando veículo com placa: {}", placa);
        Veiculo veiculo = veiculoRepository.findById(placa)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        veiculoRepository.delete(veiculo);
    }
}
