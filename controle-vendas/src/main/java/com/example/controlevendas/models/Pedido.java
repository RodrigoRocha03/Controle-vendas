package com.example.controlevendas.models;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "Tb_Pedido")
public class Pedido implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "VARCHAR(36)")
	@Type(type = "uuid-char")
	private UUID IdPedido;

	@ManyToOne
	@JoinColumn(name = "Cpf")
	private Cliente cliente;

	@Column(nullable = false)
	private LocalDateTime DataPedido;

	public UUID getIdPedido() {
		return IdPedido;
	}

	public void setIdPedido(UUID idPedido) {
		IdPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getDataPedido() {
		return DataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		DataPedido = dataPedido;
	}

}
