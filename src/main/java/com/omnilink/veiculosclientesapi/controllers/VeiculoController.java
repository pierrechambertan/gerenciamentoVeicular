package com.omnilink.veiculosclientesapi.controllers;

import com.omnilink.veiculosclientesapi.domain.veiculo.Veiculo;
import com.omnilink.veiculosclientesapi.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAllVeiculos() {
        List<Veiculo> veiculos = veiculoService.findAll();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable String placa) {
        Veiculo veiculo = veiculoService.findById(placa)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Veiculo> createVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoService.create(veiculo);
        return ResponseEntity.ok(novoVeiculo);
    }

    @PutMapping("/{placa}")
    public ResponseEntity<Veiculo> updateVeiculo(@PathVariable String placa, @RequestBody Veiculo veiculoDetails) {
        Veiculo updatedVeiculo = veiculoService.update(placa, veiculoDetails);
        return ResponseEntity.ok(updatedVeiculo);
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable String placa) {
        veiculoService.delete(placa);
        return ResponseEntity.noContent().build();
    }
}
