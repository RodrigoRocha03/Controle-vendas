package com.example.controlevendas.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		/*if (clienteService.existsByCpf(clienteDto.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Esse Cpf ja foi cadastrado!");
		}*/

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

	@GetMapping("/busca-cliente/{cpf}")
	@ApiOperation(value = "Retorna um cadastro unico")
	public ResponseEntity<Object> getOneCliente(@PathVariable(value = "cpf") String cpf) {
		Optional<Cliente> clienteOptional = clienteService.findByCpf(cpf);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf não cadastrado ou inexistente.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
	}

	/*@DeleteMapping("/deleta-cliente/{cpf}")
	@ApiOperation(value = "Exclui um cadastro de cliente")
	public ResponseEntity<Object> deleteCliente(@PathVariable(value = "cpf") String cpf) {
		Optional<Cliente> clienteOptional = clienteService.findByCpf(cpf);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf não cadastrado ou inexistente.");
		}
		clienteService.delete(clienteOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso.");
	}*/

	/*@PutMapping("/atualiza-cliente/{cpf}")
	@ApiOperation(value = "Atualiza um cadastro de cliente")
	public ResponseEntity<Object> updateCliente(@PathVariable(value = "cpf") String cpf,
			@RequestBody @Valid ClienteDto clienteDto) {
		Optional<Cliente> clienteOptional = clienteService.findByCpf(cpf);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf não cadastrado ou inexistente.");
		}
		var cliente = new Cliente();
		BeanUtils.copyProperties(clienteDto, cliente);
		cliente.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		cliente.setCpf(clienteOptional.get().getCpf());
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
	}*/
}
