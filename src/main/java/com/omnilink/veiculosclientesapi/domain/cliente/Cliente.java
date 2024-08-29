package com.omnilink.veiculosclientesapi.domain.cliente;

import com.omnilink.veiculosclientesapi.domain.veiculo.Veiculo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos")
    @Column(length = 11, unique = true, nullable = false)
    private String cpf;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    @Size(max = 15, message = "O telefone deve ter no máximo 15 caracteres")
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Veiculo> veiculos;
}
