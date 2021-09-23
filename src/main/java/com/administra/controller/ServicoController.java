package com.administra.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.administra.dto.ServicoDTO;
import com.administra.models.Cliente;
import com.administra.models.Servico;
import com.administra.repositories.ClientesRepository;
import com.administra.repositories.ServicoRepository;
import com.administra.util.BigDecimalConverter;

@RestController
@RequestMapping("/api/servico-prestado")
@CrossOrigin("http://localhost:4200")
public class ServicoController {
	
	private final ClientesRepository clienteRepository;
	private final ServicoRepository servicoRepository;
	private final BigDecimalConverter bigDecimalConverter;
	

	public ServicoController(ClientesRepository clienteRepository, ServicoRepository servicoRepository, BigDecimalConverter bigDecimalConverter) {
		this.clienteRepository = clienteRepository;
		this.servicoRepository = servicoRepository;
		this.bigDecimalConverter = bigDecimalConverter;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico salvar(@RequestBody ServicoDTO dto) {
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Integer idCliente = dto.getIdCliente();
		
		Cliente cliente = clienteRepository
							.findById(idCliente)
							.orElseThrow(() -> 
								new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente Inexistente"));
		
		Servico servico = new Servico();
		servico.setDescricao(dto.getDescricao());
		servico.setData( data );
		servico.setClientes(cliente);
		servico.setValor(bigDecimalConverter.converter(dto.getPreco()));
		
		return servicoRepository.save(servico);
		
	}
	
	@GetMapping
	public List<Servico> pesquisar(
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "mes", required = false) Integer mes
	){
		return servicoRepository.findByNameAndMes("%" + name + "%", mes);
	}
	
	
	

}
