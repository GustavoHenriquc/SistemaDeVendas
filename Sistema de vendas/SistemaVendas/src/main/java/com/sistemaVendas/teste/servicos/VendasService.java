package com.sistemaVendas.teste.servicos;

import com.sistemaVendas.teste.DTO.ProdutoVendidoRelatorioDTO;
import com.sistemaVendas.teste.models.Cliente;
import com.sistemaVendas.teste.models.Produto;
import com.sistemaVendas.teste.models.Vendido;
import com.sistemaVendas.teste.repositorios.ClienteRepository;
import com.sistemaVendas.teste.repositorios.ProdutoRepository;
import com.sistemaVendas.teste.repositorios.VendidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendasService {

    @Autowired //Injeção do java
    ProdutoRepository produtoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VendidoRepository vendidoRepository;

    @Autowired
    ClienteService service;

    public ProdutoVendidoRelatorioDTO vendeProduto(Integer produtoId, Integer clienteId){
        //Vendendo produto pro cliente
        Vendido vendido = new Vendido();

        //Quando o repositorio retorna uma coisa opicional(que pode existir ou não) precisa usar throw, pra que caso não exista, ele jogar um erro
        Produto produto = produtoRepository.findById(produtoId).orElseThrow();
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow();

        ProdutoVendidoRelatorioDTO dto = new ProdutoVendidoRelatorioDTO();

        //Salvo dentro do produto que foi vendido o id do produto e o id do cliente
        vendido.setProdutoId(produto);
        vendido.setClienteId(cliente);
        vendido.setDataVenda(LocalDate.now());

        //O dto serve pra mostrar só algum dado específico, assim eu não mostro tudo do cliente e nem tudo do produto
        dto.setDataVenda(vendido.getDataVenda().atStartOfDay()); // Pegando a data do vendido de cima
        dto.setProduto(produto);
        dto.setCliente(cliente);

        vendidoRepository.save(vendido);

        return dto;
    }

    public List<Vendido> listaRelatorio(){ // Função que retorna tudo que ja foi vendido

        return vendidoRepository.findAll(); // Retorno a lista, estando cheia ou vazia
    }
}
