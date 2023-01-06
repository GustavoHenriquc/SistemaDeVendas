package com.sistemaVendas.teste.DTO;

import com.sistemaVendas.teste.models.Cliente;
import com.sistemaVendas.teste.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoVendidoRelatorioDTO {

    //Usando o dto pra controlar o que vai exibir

    public Cliente cliente;
    public Produto produto;
    public LocalDateTime dataVenda;
}
