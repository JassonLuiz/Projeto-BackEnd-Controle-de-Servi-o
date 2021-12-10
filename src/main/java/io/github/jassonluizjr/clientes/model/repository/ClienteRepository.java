package io.github.jassonluizjr.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jassonluizjr.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
