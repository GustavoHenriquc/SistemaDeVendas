package com.sistemaVendas.teste.controller;

import com.sistemaVendas.teste.DTO.ProdutoVendidoRelatorioDTO;
import com.sistemaVendas.teste.models.Vendido;
import com.sistemaVendas.teste.repositorios.ClienteRepository;
import com.sistemaVendas.teste.repositorios.ProdutoRepository;
import com.sistemaVendas.teste.servicos.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {

    @Autowired
    VendasService service;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping(path = "/vender/{produtoId}/{clienteId}")
    public ResponseEntity<?> venderProduto(@PathVariable("produtoId") Integer produtoId, // A melhor forma de passar ID é pela rota
                                           @PathVariable("clienteId") Integer clienteId) {

        if (!clienteRepository.existsById(clienteId))
            return ResponseEntity.ok(("O Cliente informado não existe"));

        if (!produtoRepository.existsById(produtoId))
            return ResponseEntity.ok(("O Produto informado não existe"));

        return ResponseEntity.ok(service.vendeProduto(produtoId, clienteId)); // Quando retorno a função desse jeito, o retorno dela me dá o objeto que a função retorna
    }

    @GetMapping(path = "/relatorio")
    public ResponseEntity<?> relatorioVendidos() {
        // a ResponseEntity é o melhor jeito de retornar coisa pra um controller, porque ela constroi uma resposta que tem um Status, seja ele OK, ERRO, NOT FOUND ou outros
        return ResponseEntity.ok(service.listaRelatorio());
    }
}
