package br.com.mercadinho.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produtos {

	private String nome;
	private String descricao;
	private double preco;
	private int quantidadeEstoque;
	private String codigoProduto;
	private double peso; // (para cálculo de frete),
//	private ProdutosDimensoes dimensoes;
///	private Subcategorias subcategorias;
//	private String imagens;

}
