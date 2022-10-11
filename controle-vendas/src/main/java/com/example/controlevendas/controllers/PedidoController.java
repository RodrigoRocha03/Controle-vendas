package com.example.controlevendas.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/cadastro-pedido")
@Api(value = "Cadastro do pedido API REST")
@CrossOrigin(origins = "*")
public class PedidoController {

}
