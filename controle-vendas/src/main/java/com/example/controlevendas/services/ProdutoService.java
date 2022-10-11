package com.example.controlevendas.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.controlevendas.models.Produto;

import com.example.controlevendas.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Transactional
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
}
