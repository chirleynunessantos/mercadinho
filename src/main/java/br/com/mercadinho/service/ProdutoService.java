package br.com.mercadinho.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadinho.model.Produtos;
import br.com.mercadinho.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public void deleteProduto(String codigoProduto) {

	}

	public List<Produtos> listarTodosProdutos() {
		List<Produtos> produtos = new ArrayList<>();
		produtos = produtoRepository.findAll();
		return produtos;

	}

	public void salvarProduto(Produtos produtos) {
		produtoRepository.save(produtos);
	}

	public void alterarProduto(Produtos produtos) {
		produtoRepository.save(produtos);
	}

	public Optional<Produtos>  buscarProduto(String codigoProduto) {
		
		Optional<Produtos> produtos = produtoRepository.findById(codigoProduto);
		return produtos;

	}
}
