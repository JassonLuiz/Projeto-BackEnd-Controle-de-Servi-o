package io.github.jassonluizjr.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jassonluizjr.clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
