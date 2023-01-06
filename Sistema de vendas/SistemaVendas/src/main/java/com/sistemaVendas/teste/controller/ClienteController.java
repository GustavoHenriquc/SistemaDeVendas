package com.sistemaVendas.teste.controller;

import com.sistemaVendas.teste.models.Cliente;
import com.sistemaVendas.teste.repositorios.ClienteRepository;
import com.sistemaVendas.teste.servicos.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @Autowired
    ClienteRepository repository;


    @PostMapping(path = "/criar")
    public String criarUsuario(@RequestBody Cliente cliente){ // Precisa de um objeto com os dados do cliente
        service.salvaCliente(cliente);
        return "Cliente cadastrado";
    }

    @GetMapping(path = "/buscaPorId/{id}")
    public Cliente buscarPorId(@PathVariable (name = "id", required = true) Integer id) {
        Cliente cliente = service.buscaPeloId(id).orElseThrow();
        return cliente;
    }

    @GetMapping(path = "/buscatodos")
    public List<Cliente> buscaTodosClientes(){
        return repository.findAll();
    }

    @PostMapping(path = "/atualizar/{id}")
    public Cliente atualizarCliente(@PathVariable (name = "id", required = true) Integer id,
                                    @RequestBody Cliente corpo) { // Pego o corpo que é enviado
        return service.atualizaCliente(id, corpo); //Atualizo o cliente com o ID e mostro ele
    }

    @DeleteMapping(path = "/apagaCliente/{id}")
    public void apagaCliente(@PathVariable (name = "id", required = true) Integer id) {
        service.deletaCliente(id); // Como o objetivo é apenas deletar o cliente, esse método não precisa de retorno
    }
}
