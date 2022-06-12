package com.administra.controller;

import javax.validation.Valid;

import com.administra.exceptions.UsuarioCadastradoException;
import com.administra.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.administra.models.Usuario;
import com.administra.repositories.UsuarioRepository;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private final UsuarioRepository repository;
	private final UsuarioService service;


	public UsuarioController(UsuarioRepository repository, UsuarioService service) {
		super();
		this.repository = repository;
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarUsuario(@RequestBody @Valid Usuario username) {
		try {
			service.salvar(username);
		}catch (UsuarioCadastradoException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
