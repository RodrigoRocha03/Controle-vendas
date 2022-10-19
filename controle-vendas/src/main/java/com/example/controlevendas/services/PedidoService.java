package com.example.controlevendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controlevendas.models.Pedido;

import com.example.controlevendas.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
}
