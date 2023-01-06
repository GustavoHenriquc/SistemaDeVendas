package com.sistemaVendas.teste.servicos;

import com.sistemaVendas.teste.models.Cliente;
import com.sistemaVendas.teste.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired //Injeção do java
    ClienteRepository repository;

    //Como o usuário pode não existir, é bom usar opicional

    public Cliente salvaCliente(Cliente cliente) {
        repository.save(cliente);
        return cliente;
    }

    public Optional<Cliente> buscaPeloId(Integer id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente;
    }

    public Cliente atualizaCliente(Integer id, Cliente corpo) {
        Cliente cliente = repository.findById(id).orElseThrow(); // Quando é opicional precisa por isso pra caso não existir, nada acontecer
        cliente = corpo;
        repository.save(cliente);
        return cliente;
    }

    public void deletaCliente (Integer id) {
        Cliente cliente = repository.findById(id).orElseThrow(); // Achando um cliente com o ID
        repository.delete(cliente); // Apaga o cliente
        // Método void não retorna nada, mas pode retornar uma mensagem de ok por exemplo.
    }


}
