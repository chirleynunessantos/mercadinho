package br.com.mercadinho.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercadinho.filerepository.ProdutosRepository;
import br.com.mercadinho.model.Produtos;
@Service
public class ProdutosService {

	@Autowired
	ProdutosRepository  produtosRepository;
	
	public void deleteProduto(String codigoProduto) {
		
		File file = new File("C:\\Users\\PICHAU\\git\\repository\\Mercadinho\\arquivos\\produtos.txt");
		
		if(	file.exists()) {				
			
			produtosRepository.deleteProduto(file,codigoProduto);
		
		}
	}
	
	public 	List<Produtos> listarTodosProdutos() {
		List<Produtos> produtos = new ArrayList<>();
		File file = new File("C:\\Users\\PICHAU\\git\\repository\\Mercadinho\\arquivos\\produtos.txt");
		if(	file.exists()) {				
			try {
				 produtos =  produtosRepository.listarTodosProdutos(file);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else{
			System.out.println("Não existe esta pasta");
		}
		return produtos;
		
	}
	
	public void salvarProduto(Produtos produtos) {
		
		File file = new File("C:\\Users\\PICHAU\\git\\repository\\Mercadinho\\arquivos\\produtos.txt");
		String linhaParaSalvar="";
		if(	file.exists()) {				
			String[] produtosArray = new String[6];
				List<Produtos> listaProdutos = List.of(produtos);

	            for (Produtos produto : listaProdutos) {
	                 linhaParaSalvar = produto.getNome() + "," +
	                                         produto.getDescricao() + "," +
	                                         produto.getPreco() + "," +
	                                         produto.getQuantidadeEstoque() + "," +
	                                         produto.getCodigoProduto() + "," +
	                                         produto.getPeso();
	            }
			produtosRepository.salvarProduto(file,linhaParaSalvar);
		}else{
			
			try {
				
				boolean isCreated = file.createNewFile();
		
				if(isCreated) {
					produtosRepository.salvarProduto(file,linhaParaSalvar);					
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void alterarProduto(Produtos produtos) {
		File file = new File("C:\\Users\\PICHAU\\git\\repository\\Mercadinho\\arquivos\\produtos.txt");
		String linhaParaSalvar="";
		if(	file.exists()) {				
			String[] produtosArray = new String[6];
				List<Produtos> listaProdutos = List.of(produtos);

	            for (Produtos produto : listaProdutos) {
	                 linhaParaSalvar = produto.getNome() + "," +
	                                         produto.getDescricao() + "," +
	                                         produto.getPreco() + "," +
	                                         produto.getQuantidadeEstoque() + "," +
	                                         produto.getCodigoProduto() + "," +
	                                         produto.getPeso();
	            }
			produtosRepository.alterarProduto(file,linhaParaSalvar, produtos.getCodigoProduto());
		}else{
			
			try {
				
				boolean isCreated = file.createNewFile();
		
				if(isCreated) {
					produtosRepository.alterarProduto(file,linhaParaSalvar, produtos.getCodigoProduto());					
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
