package com.example.controlevendas.models;

import java.util.UUID;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Tb_Produto")
public class Produto {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "VARCHAR(36)")
	@Type(type = "uuid-char")
	private UUID IdProduto;

	@Column(nullable = false, length = 200)
	private String descricao;

	@Column(nullable = false)
	private String valorProduto;
	
	@ManyToOne
    @JoinColumn(name="pedido_id_pedido", nullable=false)
	private Pedido pedido;


	public UUID getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(UUID idProduto) {
		IdProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(String valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
