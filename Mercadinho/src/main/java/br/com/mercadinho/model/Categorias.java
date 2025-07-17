package br.com.mercadinho.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categorias {

	String nome;
	String descricao;
	Subcategorias subcategoria;
}
