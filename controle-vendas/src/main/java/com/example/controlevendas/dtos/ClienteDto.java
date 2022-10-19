package com.example.controlevendas.dtos;

import javax.validation.constraints.NotBlank;

public class ClienteDto {

	@NotBlank
	private String cpf;

	@NotBlank
	private String nome;

	@NotBlank
	private String endereco;

	public ClienteDto() {
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
