package com.example.controlevendas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.controlevendas.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

}
