package com.sistemaVendas.teste.repositorios;

import com.sistemaVendas.teste.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
