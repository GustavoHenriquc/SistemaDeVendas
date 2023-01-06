package com.sistemaVendas.teste.servicos;

import com.sistemaVendas.teste.models.Produto;
import com.sistemaVendas.teste.repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired //Injeção do java
    ProdutoRepository repository;

    //Como o usuario pode não existir, é bom usar opicional

    public Produto salvaProduto(Produto produto) {
        repository.save(produto);
        return produto;
    }

    public Optional<Produto> buscaPeloId(Integer id) {
        Optional<Produto> produto = repository.findById(id);
        return produto;
    }

    public Produto atualizaProduto(Integer id, Produto corpo) {
        Produto produto = repository.findById(id).orElseThrow(); // Quando é opicional precisa por isso pra caso não existir, nada acontecer
        produto = corpo;
        repository.save(produto);
        return produto;
    }

    public void deletaProduto (Integer id) {
        Produto produto = repository.findById(id).orElseThrow(); // Achando um produto com o ID
        repository.delete(produto); // Apaga ele
        // Método void não retorna nada, mas pode retornar uma mensagem de ok por exemplo.
    }


}
