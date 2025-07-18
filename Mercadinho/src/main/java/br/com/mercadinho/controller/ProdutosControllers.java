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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadinho.model.Produtos;
import br.com.mercadinho.service.ProdutosService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/produtos")
public class ProdutosControllers {

	@Autowired
	ProdutosService pordutoService;
	
	@PutMapping
	private ResponseEntity<Produtos> alterarProduto(@RequestBody Produtos produtos) {
		
		pordutoService.alterarProduto(produtos);
		
		return ResponseEntity.ok(produtos);
	}
	
	@PostMapping
	private ResponseEntity<Produtos> salvarProduto(@RequestBody Produtos produtos) {
		
		pordutoService.salvarProduto(produtos);
		
		return ResponseEntity.ok(produtos);
	}
	@DeleteMapping("{codigoProduto}")
	private ResponseEntity<Produtos> deleteProduto(@PathVariable(value = "codigoProduto") String codigoProduto ) {
		
		pordutoService.deleteProduto(codigoProduto);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	private ResponseEntity<List<Produtos>> listarTodosProdutos() {
				
		List<Produtos> produtos = pordutoService.listarTodosProdutos();
		
		return ResponseEntity.ok(produtos);
	}
}
