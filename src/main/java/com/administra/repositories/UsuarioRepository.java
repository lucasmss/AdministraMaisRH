package com.administra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.administra.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
