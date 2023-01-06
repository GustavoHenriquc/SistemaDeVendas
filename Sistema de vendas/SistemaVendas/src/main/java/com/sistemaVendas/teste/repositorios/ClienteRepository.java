package com.sistemaVendas.teste.repositorios;

import com.sistemaVendas.teste.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
