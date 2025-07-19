package br.com.mercadinho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadinho.model.Cliente;
import br.com.mercadinho.service.ClienteService;
@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	ClienteService service;
	
	@PostMapping
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
		service.salvarCliente(cliente);
		
		return ResponseEntity.ok(cliente);
	}	
	
	@PutMapping
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {
		service.alterarCliente(cliente);		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("{cpf}")
	public ResponseEntity<String> deleteCliente(@PathVariable ("cpf") String cpf) {
		service.deleteCliente(cpf);
		
		return ResponseEntity.ok("Deletado");
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarCliente() {		
		List<Cliente> clientes = service.listarCliente();		
		return ResponseEntity.ok(clientes);
	}
	
	
	@GetMapping("{cpf}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable ("cpf") String cpf) {
		Cliente clienteResponse  = service.buscarCliente(cpf);		
		return ResponseEntity.ok(clienteResponse);
	}
	
}
