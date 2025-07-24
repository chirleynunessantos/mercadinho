package br.com.mercadinho.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mercadinho.model.Cliente;

@Service
public class ClienteService {

	public void alterarCliente(Cliente cliente) {
				
	}

	public void deleteCliente(String cpf) {	
		
	}	


	public Cliente buscarCliente(String cpf) {
		Cliente cliente = null;
	
		return cliente;
	}

	public List<Cliente> listarClientes() {
		List<Cliente> listaclientes = new ArrayList<Cliente>();
		
		return listaclientes;
	}

	public void salvarCliente(Cliente cliente) {
		
	}



}
