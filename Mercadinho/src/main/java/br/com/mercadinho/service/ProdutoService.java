package br.com.mercadinho.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mercadinho.model.Produtos;

@Service
public class ProdutoService {
	
	public void deleteProduto(String codigoProduto) {

	}

	public List<Produtos> listarTodosProdutos() {
		List<Produtos> produtos = new ArrayList<>();

		return produtos;

	}

	public void salvarProduto(Produtos produtos) {

	}

	public void alterarProduto(Produtos produtos) {

	}

	public Produtos buscarProduto(String codigoProduto) {
		return null;

	}
}
