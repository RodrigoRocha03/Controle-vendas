package com.example.controlevendas.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.controlevendas.models.Cliente;
import com.example.controlevendas.repositories.ClienteRepository;

@Service
public class ClienteService {

	final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	/*public boolean existsByCpf(String cpf) {
		return clienteRepository.existsByCpf(cpf);
	}*/

	public Optional<Cliente> findByCpf(String cpf) {
		return clienteRepository.findById(cpf);
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Transactional
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
}
