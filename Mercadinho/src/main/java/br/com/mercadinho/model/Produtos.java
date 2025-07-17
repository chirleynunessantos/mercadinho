package br.com.mercadinho.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produtos {

	private String nome;
	private String descrição;
	double preço;
	private int quantidadEstoque;
	private String codigoProduto;
	private double peso; // (para cálculo de frete),
//	private ProdutosDimensoes dimensoes;
///	private Subcategorias subcategorias;
//	private String imagens;

}
