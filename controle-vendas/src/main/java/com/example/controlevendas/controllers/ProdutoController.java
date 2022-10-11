package com.example.controlevendas.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controlevendas.dtos.ProdutoDto;

import com.example.controlevendas.models.Produto;

import com.example.controlevendas.services.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cadastro-produto")
@Api(value = "Cadastro do produto API REST")
@CrossOrigin(origins = "*")
public class ProdutoController {

	final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@PostMapping
	@ApiOperation(value = "Cadastra um Produto")
	public ResponseEntity<Object> saveProduto(@RequestBody @Valid ProdutoDto produtoDto) {
		/*
		 * if (clienteService.existsByCpf(clienteDto.getCpf())) { return
		 * ResponseEntity.status(HttpStatus.CONFLICT).
		 * body("Conflict: Esse Cpf ja foi cadastrado!"); }
		 */

		var produto = new Produto();
		BeanUtils.copyProperties(produtoDto, produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
	}
}
