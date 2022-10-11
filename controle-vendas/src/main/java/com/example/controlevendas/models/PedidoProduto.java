package com.example.controlevendas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tb_Pedido_Produto")
public class PedidoProduto {

	@ManyToOne
	@JoinColumn(name = "Cpf")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "Id_Produto")
	private Produto produto;
	
	@OneToOne
	@JoinColumn(name = "Id_Pedido")
	private Pedido pedido;
	
	@Column(nullable = false)
	private float valorProduto;
	
	@Column(nullable = false)
	private int quantidade;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
