package com.administra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.administra.models.Usuario;
import com.administra.repositories.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private final UsuarioRepository repository;
	
	
	public UsuarioController(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarUsuario(@RequestBody @Valid Usuario usuario) {
		
		repository.save(usuario);
	}

}
