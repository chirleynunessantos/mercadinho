package br.com.mercadinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mercadinho.model.Produtos;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produtos, String>{

}
