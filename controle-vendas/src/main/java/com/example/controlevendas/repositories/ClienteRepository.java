package com.example.controlevendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.controlevendas.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
