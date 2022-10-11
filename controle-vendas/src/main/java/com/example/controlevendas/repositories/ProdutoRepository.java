package com.example.controlevendas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.controlevendas.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

}
