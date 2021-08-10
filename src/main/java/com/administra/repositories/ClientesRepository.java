package com.administra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.administra.models.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Integer>{

}
