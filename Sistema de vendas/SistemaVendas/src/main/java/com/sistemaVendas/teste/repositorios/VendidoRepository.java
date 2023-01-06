package com.sistemaVendas.teste.repositorios;

import com.sistemaVendas.teste.models.Vendido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendidoRepository extends JpaRepository<Vendido, Integer> { }
