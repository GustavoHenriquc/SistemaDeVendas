package com.sistemaVendas.teste.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @Column(name = "produtoId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nome é obrigatório.")
    @Column(name = "produtoNome", length = 80)
    private String nome;

    @NotNull(message = "Preço é obrigatório.")
    @Column(name = "produtoPreco")
    private Double preco;

    @Column(name = "produtoDescricao", length = 255)
    private String descricao;

}