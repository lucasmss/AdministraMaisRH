package com.administra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.administra.models.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByUsername(String username);

    //select count(*) > 0 from usuarios where username =:login
    boolean existsByUsername(String username);
}
