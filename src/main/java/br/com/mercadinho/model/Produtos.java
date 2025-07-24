package br.com.mercadinho.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produtos {

	

	@Id
	private String codigoProduto;
	private String nome;
	private String descricao;
	private double preco;
	private int quantidadeEstoque;

	private double peso; // (para cálculo de frete),
//	private ProdutosDimensoes dimensoes;
///	private Subcategorias subcategorias;
//	private String imagens;

}
