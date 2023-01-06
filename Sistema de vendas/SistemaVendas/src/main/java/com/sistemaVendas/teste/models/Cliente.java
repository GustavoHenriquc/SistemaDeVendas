package com.sistemaVendas.teste.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "clienteId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Adicionei a dependencia de validation pra não aceitar vazio, é melhor do que fazer com if porque gasta menos linha
    @NotBlank(message = "Nome é obrigatório.")
    @Column(name = "clienteNome", length = 100) // Limitando o tamanho do que pode ser colocado
    private String nome;

    @NotBlank(message = "Email é obrigatório.")
    @Column(name = "clienteEmail", length = 200)
    private String email;

    @Column(name = "clienteTelefone", length = 20)
    private String telefone;

}