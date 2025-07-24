package br.com.mercadinho.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	private String	nomeCompleto; 
	private String cpfCnpj;  
	private String email;  
	private String telefone;  
//	private Endereços endereco;
}
