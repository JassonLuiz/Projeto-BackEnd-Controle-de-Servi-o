package io.github.jassonluizjr.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jassonluizjr.clientes.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
