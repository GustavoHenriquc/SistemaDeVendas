package com.sistemaVendas.teste.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vendido")
public class Vendido {
    @Id
    @Column(name = "vendaId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "clienteId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente clienteId;

    @JoinColumn(name = "produtoId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Produto produtoId;

    @Column(name = "dataVenda")
    private LocalDate dataVenda;
}

