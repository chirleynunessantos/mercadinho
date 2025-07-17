package br.com.mercadinho.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import br.com.mercadinho.model.Produtos;

@RestController
@RequestMapping("/produtos")
public class ProdutosControllers {

	@PostMapping
	private ResponseEntity<Produtos> salvarProduto(@RequestBody Produtos produtos) {
		System.out.println(produtos);
		return ResponseEntity.ok(produtos);
	}
}
