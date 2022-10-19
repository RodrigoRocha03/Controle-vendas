package com.example.controlevendas.dtos;

import javax.validation.constraints.NotBlank;

public class ProdutoDto {

	@NotBlank
	private String descricao;

	@NotBlank
	private String ValorProduto;

	public ProdutoDto() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValorProduto() {
		return ValorProduto;
	}

	public void setValorProduto(String valorProduto) {
		ValorProduto = valorProduto;
	}

}
