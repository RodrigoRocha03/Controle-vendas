package com.example.controlevendas.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controlevendas.dtos.PedidoDto;
import com.example.controlevendas.models.Cliente;
import com.example.controlevendas.models.Pedido;
import com.example.controlevendas.services.PedidoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cadastro-pedido")
@Api(value = "Cadastro do pedido API REST")
@CrossOrigin(origins = "*")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	@ApiOperation(value = "Cadastra um Pedido")
	public ResponseEntity<Object> savePedido(@RequestBody @Valid PedidoDto pedidoDto) {
		var pedido = new Pedido();
		var cliente = new Cliente();
		cliente.setCpf(pedidoDto.getCpf());
		pedido.setCliente(cliente);	
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedido));
	}

}
