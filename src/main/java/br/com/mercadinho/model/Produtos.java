package br.com.mercadinho.model;

import jakarta.persistence.Column;
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
	    // Se o codigo_produto for gerado pelo banco, você precisaria de @GeneratedValue
	    // Mas como é VARCHAR(10) e PRIMARY KEY, pode ser um ID definido manualmente.
	    // Se for um ID manual, remova @GeneratedValue.
	    @Column(name = "codigo_produto") // Use o nome exato da coluna no banco, incluindo a caixa
	    private String codigoProduto; // O tipo deve ser String para VARCHAR

	    @Column(name = "nome_produto") // Certifique-se que o nome da coluna aqui é 'nome_produto'
	    private String nome; // Ou nomeProduto, dependendo do seu campo

	    @Column(name = "preco")
	    private Double preco; // Ou BigDecimal para NUMERIC

	    @Column(name = "quantidade_estoque")
	    private Integer quantidadeEstoque;
	    
	    @Column(name = "descricao")
	    private String  descricao;
	    
	    @Column(name = "peso")
	    private Double peso; // Ou BigDecimal para NUMERIC // (para cálculo de frete),
//	private ProdutosDimensoes dimensoes;
///	private Subcategorias subcategorias;
//	private String imagens;

}
