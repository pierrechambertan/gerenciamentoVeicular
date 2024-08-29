package com.omnilink.veiculosclientesapi.domain.veiculo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omnilink.veiculosclientesapi.domain.cliente.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "veiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @NotBlank(message = "A placa é obrigatória")
    @Pattern(regexp = "[A-Z]{3}\\d{4}", message = "A placa deve estar no formato ABC1234")
    @Column(length = 7, unique = true, nullable = false)
    private String placa;

    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    @Column(nullable = false)
    private int ano;

    @ManyToOne
    @JoinColumn(name = "cpf_cliente", nullable = false)
    @JsonIgnore
    private Cliente cliente;
}
