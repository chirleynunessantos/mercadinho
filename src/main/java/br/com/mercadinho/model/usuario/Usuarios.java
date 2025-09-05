package br.com.mercadinho.model.usuario;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
@Entity(name = "usuarios")
@EqualsAndHashCode(of="id")
public class Usuarios implements UserDetails {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String codigo;
		
		@Column(name = "NOMECOMPLETO")
		private String nomeCompleto;
		
		private String login;
		
		private String senha;

		private String cargo;
		
		private UsuariosRole role;
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			
			if(this.role==UsuariosRole.ADMIN) 
				return List.of(
								new SimpleGrantedAuthority("ROLE_ADMIN,"),
								new SimpleGrantedAuthority("ROLE_USER,"));
			else return List.of(
					new SimpleGrantedAuthority("ROLE_USER,"));
		}

		@Override
		public String getPassword() {
				return senha;
		}

		@Override
		public String getUsername() {
				return login;
		}

		public Usuarios(String nomeCompleto, String login, String senha, String cargo, UsuariosRole role) {
			super();
			this.nomeCompleto = nomeCompleto;
			this.login = login;
			this.senha = senha;
			this.cargo = cargo;
			this.role = role;
		}

		public Usuarios(String login, String senha) {
			super();
			this.login = login;
			this.senha = senha;
		}

	
		
		
		
	
		
		
		


}
