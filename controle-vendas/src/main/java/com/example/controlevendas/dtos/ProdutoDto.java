package com.example.controlevendas.dtos;

import javax.validation.constraints.NotBlank;

public class ProdutoDto {

	@NotBlank
	private String descricao;

	@NotBlank
	private float ValorProduto;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValorProduto() {
		return ValorProduto;
	}

	public void setValorProduto(float valorProduto) {
		ValorProduto = valorProduto;
	}

}
