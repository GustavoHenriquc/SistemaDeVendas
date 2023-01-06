package com.sistemaVendas.teste.controller;

import com.sistemaVendas.teste.models.Produto;
import com.sistemaVendas.teste.repositorios.ProdutoRepository;
import com.sistemaVendas.teste.servicos.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @Autowired
    ProdutoRepository repository;


    @PostMapping(path = "/criar")
    public String criarProduto(@RequestBody Produto produto){ // Precisa de um objeto com os dados
        service.salvaProduto(produto);
        return "Produto cadastrado";
    }

    @GetMapping(path = "/buscaPorId/{id}")
    public Produto buscarPorId(@PathVariable (name = "id", required = true) Integer id) {
        Produto produto = service.buscaPeloId(id).orElseThrow();
        return produto;
    }

    @GetMapping(path = "/buscatodos")
    public List<Produto> buscaTodosProdutos(){
        return repository.findAll();
    }

    @PostMapping(path = "/atualizar/{id}")
    public Produto atualizarProduto(@PathVariable (name = "id", required = true) Integer id,
                                    @RequestBody Produto corpo) { // Pego o corpo que é enviado
        return service.atualizaProduto(id, corpo); // Atualizo o produto com o ID e mostro ele
    }

    @DeleteMapping(path = "/apagaProduto/{id}")
    public void apagaCliente(@PathVariable (name = "id", required = true) Integer id) {
        service.deletaProduto(id); // Como o objetivo é apenas deletar o produto, esse método não precisa de retorno
    }
}
