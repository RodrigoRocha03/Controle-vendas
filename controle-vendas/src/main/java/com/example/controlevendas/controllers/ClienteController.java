package com.example.controlevendas.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controlevendas.dtos.ClienteDto;
import com.example.controlevendas.models.Cliente;
import com.example.controlevendas.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cadastro-cliente")
@Api(value = "Cadastro do cliente API REST")
@CrossOrigin(origins = "*")
public class ClienteController {

	final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	@ApiOperation(value = "Cadastra um Cliente")
	public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDto clienteDto) {
		var cliente = new Cliente();
		BeanUtils.copyProperties(clienteDto, cliente);
		cliente.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}

	@GetMapping("/Lista-Clientes")
	@ApiOperation(value = "Retorna a lista do cadastro dos clientes")
	public ResponseEntity<List<Cliente>> getAllClientes() {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}

}
